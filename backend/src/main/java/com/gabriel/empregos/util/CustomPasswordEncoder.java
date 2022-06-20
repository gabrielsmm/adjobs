package com.gabriel.empregos.util;

import java.security.SecureRandom;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

	private Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2(a|y|b)?\\$(\\d\\d)\\$[./0-9A-Za-z]{53}");

	private final Log logger = LogFactory.getLog(getClass());

	private final int strength;

	private final CustomPasswordEncoderVersion version;

	private final SecureRandom random;

	public CustomPasswordEncoder() {
		this(-1);
	}

	public CustomPasswordEncoder(int strength) {
		this(strength, null);
	}

	public CustomPasswordEncoder(CustomPasswordEncoderVersion version) {
		this(version, null);
	}

	public CustomPasswordEncoder(CustomPasswordEncoderVersion version, SecureRandom random) {
		this(version, -1, random);
	}

	public CustomPasswordEncoder(int strength, SecureRandom random) {
		this(CustomPasswordEncoderVersion.$2A, strength, random);
	}

	public CustomPasswordEncoder(CustomPasswordEncoderVersion version, int strength) {
		this(version, strength, null);
	}

	public CustomPasswordEncoder(CustomPasswordEncoderVersion version, int strength, SecureRandom random) {
		if (strength != -1 && (strength < 4 || strength > 31)) {
			throw new IllegalArgumentException("Bad strength");
		}
		this.version = version;
		this.strength = (strength == -1) ? 10 : strength;
		this.random = random;
	}

	@Override
	public String encode(CharSequence rawPassword) {
		if (rawPassword == null) {
			throw new IllegalArgumentException("rawPassword cannot be null");
		}
		rawPassword = reverseCustom(rawPassword.toString());
		String salt = getSalt();
		return BCrypt.hashpw(rawPassword.toString(), salt);
	}

	private String getSalt() {
		if (this.random != null) {
			return BCrypt.gensalt(this.version.getVersion(), this.strength, this.random);
		}
		return BCrypt.gensalt(this.version.getVersion(), this.strength);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if (rawPassword == null) {
			throw new IllegalArgumentException("rawPassword cannot be null");
		}
		if (encodedPassword == null || encodedPassword.length() == 0) {
			this.logger.warn("Empty encoded password");
			return false;
		}
		if (!this.BCRYPT_PATTERN.matcher(encodedPassword).matches()) {
			this.logger.warn("Encoded password does not look like BCrypt");
			return false;
		}
		rawPassword = reverseCustom(rawPassword.toString());
		return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}

	@Override
	public boolean upgradeEncoding(String encodedPassword) {
		if (encodedPassword == null || encodedPassword.length() == 0) {
			this.logger.warn("Empty encoded password");
			return false;
		}
		Matcher matcher = this.BCRYPT_PATTERN.matcher(encodedPassword);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Encoded password does not look like BCrypt: " + encodedPassword);
		}
		int strength = Integer.parseInt(matcher.group(2));
		return strength < this.strength;
	}
	
	/*
	 * Reverte a string passada como parâmetro
	 */
    private String reverse(String str){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder strb = new StringBuilder();
        while (!stack.empty()) {
            strb.append(stack.pop());
        }
        return strb.toString();
    }
    
    private String reverseCustom(String str){
        String parte1 = reverse(str.substring(0, str.length()/2));
        String parte2 = reverse(str.substring(str.length()/2, str.length()));
        return new StringBuilder().append(parte1).append(parte2).toString();
    }

	/**
	 * Salva a versão padrão para uso na configuração.
	 */
	public enum CustomPasswordEncoderVersion {

		$2A("$2a"),

		$2Y("$2y"),

		$2B("$2b");

		private final String version;

		CustomPasswordEncoderVersion(String version) {
			this.version = version;
		}

		public String getVersion() {
			return this.version;
		}

	}
	
}
