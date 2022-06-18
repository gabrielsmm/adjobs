package com.gabriel.empregos.util;

import java.security.SecureRandom;
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

	/**
	 * @param strength the log rounds to use, between 4 and 31
	 */
	public CustomPasswordEncoder(int strength) {
		this(strength, null);
	}

	/**
	 * @param version the version of bcrypt, can be 2a,2b,2y
	 */
	public CustomPasswordEncoder(CustomPasswordEncoderVersion version) {
		this(version, null);
	}

	/**
	 * @param version the version of bcrypt, can be 2a,2b,2y
	 * @param random the secure random instance to use
	 */
	public CustomPasswordEncoder(CustomPasswordEncoderVersion version, SecureRandom random) {
		this(version, -1, random);
	}

	/**
	 * @param strength the log rounds to use, between 4 and 31
	 * @param random the secure random instance to use
	 */
	public CustomPasswordEncoder(int strength, SecureRandom random) {
		this(CustomPasswordEncoderVersion.$2A, strength, random);
	}

	/**
	 * @param version the version of bcrypt, can be 2a,2b,2y
	 * @param strength the log rounds to use, between 4 and 31
	 */
	public CustomPasswordEncoder(CustomPasswordEncoderVersion version, int strength) {
		this(version, strength, null);
	}

	/**
	 * @param version the version of bcrypt, can be 2a,2b,2y
	 * @param strength the log rounds to use, between 4 and 31
	 * @param random the secure random instance to use
	 */
	public CustomPasswordEncoder(CustomPasswordEncoderVersion version, int strength, SecureRandom random) {
//		if (strength != -1 && (strength < BCrypt.MIN_LOG_ROUNDS || strength > BCrypt.MAX_LOG_ROUNDS)) {
//			throw new IllegalArgumentException("Bad strength");
//		}
		this.version = version;
		this.strength = (strength == -1) ? 10 : strength;
		this.random = random;
	}

	@Override
	public String encode(CharSequence rawPassword) {
		if (rawPassword == null) {
			throw new IllegalArgumentException("rawPassword cannot be null");
		}
		rawPassword = reverse(rawPassword.toString(), rawPassword.toString().length()-1);
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
		rawPassword = reverse(rawPassword.toString(), rawPassword.toString().length()-1);
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
	 * Reverte a string passada de forma recursiva
	 */
	private String reverse(String str, int index){
		if(index == 0){
			return str.charAt(0) + "";
		}
		char letter = str.charAt(index);
		return letter + reverse(str, index-1);
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
