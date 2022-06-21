package com.gabriel.empregos.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.gabriel.empregos.security.JwtTokenAuthenticationFilter;
import com.gabriel.empregos.security.JwtTokenProvider;

@Configuration
public class SecurityConfig {
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	
	@Bean
    SecurityFilterChain springWebFilterChain(HttpSecurity http,
                                             JwtTokenProvider tokenProvider) throws Exception {
        return http
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(c-> c.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .authorizeRequests(c -> c
                        .antMatchers("/usuarios/login").permitAll()
                        .antMatchers(HttpMethod.POST, "/candidatos/**").permitAll()
                        .antMatchers(HttpMethod.POST, "/empresas/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(new JwtTokenAuthenticationFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
	
//	@Bean
//    UserDetailsService customUserDetailsService(UsuarioRepository users) {
//        return (email) -> users.findByEmailCustom(email)
//                .orElseThrow(() -> new ObjectNotFoundException("Username: " + username + " not found"));
//    }
//	
//	@Bean
//    AuthenticationManager customAuthenticationManager(UserDetailsService userDetailsService, PasswordEncoder encoder) {
//        return authentication -> {
//            String username = authentication.getPrincipal() + "";
//            String password = authentication.getCredentials() + "";
//            
//            UserDetails user = userDetailsService.loadUserByUsername(username);
//            
//            if (!encoder.matches(password, user.getPassword())) {
//                throw new BadCredentialsException("Bad credentials");
//            }
//            
//            if (!user.isEnabled()) {
//                throw new DisabledException("User account is not active");
//            }
//            
//            return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
//        };
//    }

//	@Autowired
//	private Environment env;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
//			http.headers().frameOptions().disable();
//		}
//		
//		http.cors().and().csrf().disable();
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.authorizeRequests().anyRequest().permitAll();
////		http.authorizeRequests().antMatchers("usuarios/login", "candidatos/create", "empresas/create").permitAll().and().httpBasic();
//	}

}
