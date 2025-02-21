/*
 * Open Hospital (www.open-hospital.org)
 * Copyright © 2006-2023 Informatici Senza Frontiere (info@informaticisenzafrontiere.org)
 *
 * Open Hospital is a free and open source software for healthcare data management.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * https://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */
package org.isf.config;

import java.util.Arrays;

import org.isf.security.CustomLogoutHandler;
import org.isf.security.OHSimpleUrlAuthenticationSuccessHandler;
import org.isf.security.RestAuthenticationEntryPoint;
import org.isf.security.jwt.JWTConfigurer;
import org.isf.security.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	private final TokenProvider tokenProvider;

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	public SecurityConfig(TokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

	@Autowired
	private CustomLogoutHandler customLogoutHandler;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedHeader("*");
		// config.setAllowedHeaders(Arrays.asList("Accept", "Accept-Encoding", "Accept-Language", "Authorization", "Content-Type", "Cache-Control",
		// "Connection", "Cookie", "Host", "Pragma", "Referer, User-Agent"));
		config.setAllowedMethods(Arrays.asList("*"));
		// config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
		config.setAllowCredentials(true);
		config.addAllowedOriginPattern("*");
		config.setMaxAge(3600L);
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						.and().cors()
						.and().csrf().disable().authorizeRequests()
						// .expressionHandler(webExpressionHandler())
						.and().exceptionHandling()
						// .accessDeniedHandler(accessDeniedHandler)
						.authenticationEntryPoint(restAuthenticationEntryPoint)
						.and().authorizeRequests().antMatchers("/auth/**").permitAll()

						// patients
						.antMatchers(HttpMethod.POST, "/patients/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/patients/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/patients/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/patients/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/patients/**").hasAnyAuthority("admin", "guest")
						// admissiontypes
						.antMatchers(HttpMethod.POST, "/admissiontypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/admissiontypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/admissiontypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/admissiontypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/admissiontypes/**").hasAnyAuthority("admin", "guest")
						// deliveryresulttype
						.antMatchers(HttpMethod.POST, "/deliveryresulttype/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/deliveryresulttype/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/deliveryresulttype/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/deliveryresulttype/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/deliveryresulttype/**").hasAnyAuthority("admin", "guest")
						// deliverytypes
						.antMatchers(HttpMethod.POST, "/deliverytypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/deliverytypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/deliverytypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/deliverytypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/deliverytypes/**").hasAnyAuthority("admin", "guest")
						// dischargetypes
						.antMatchers(HttpMethod.POST, "/dischargetypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/dischargetypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/dischargetypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/dischargetypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/dischargetypes/**").hasAnyAuthority("admin", "guest")
						// admissions
						.antMatchers(HttpMethod.POST, "/admissions/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/admissions/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/admissions/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/admissions/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/admissions/**").hasAnyAuthority("admin", "guest")
						// discharges
						.antMatchers(HttpMethod.POST, "/discharges/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/discharges/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/discharges/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/discharges/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/discharges/**").hasAnyAuthority("admin", "guest")
						// vaccines
						.antMatchers(HttpMethod.POST, "/vaccines/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/vaccines/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/vaccines/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/vaccines/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/vaccines/**").hasAnyAuthority("admin", "guest")
						// vaccineType
						.antMatchers(HttpMethod.POST, "/vaccinetype/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/vaccinetype/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/vaccinetype/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/vaccinetype/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/vaccinetype/**").hasAnyAuthority("admin", "guest")
						// visit
						.antMatchers(HttpMethod.POST, "/visit/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/visit/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/visit/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/visit/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/visit/**").hasAnyAuthority("admin", "guest")
						// wards
						.antMatchers(HttpMethod.POST, "/wards/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/wards/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/wards/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/wards/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/wards/**").hasAnyAuthority("admin", "guest")
						// exams
						.antMatchers(HttpMethod.POST, "/exams/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/exams/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/exams/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/exams/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/exams/**").hasAnyAuthority("admin", "guest")
						// examrows
						.antMatchers(HttpMethod.POST, "/examrows/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/examrows/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/examrows/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/examrows/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/examrows/**").hasAnyAuthority("admin", "guest")
						// examtypes
						.antMatchers(HttpMethod.POST, "/examtypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/examtypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/examtypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/examtypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/examtypes/**").hasAnyAuthority("admin", "guest")
						// examinations
						.antMatchers(HttpMethod.POST, "/examinations/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/examinations/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/examinations/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/examinations/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/examinations/**").hasAnyAuthority("admin", "guest")
						// hospitals
						.antMatchers(HttpMethod.POST, "/hospitals/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/hospitals/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/hospitals/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/hospitals/**").hasAuthority("admin")
						// .antMatchers(HttpMethod.GET, "/hospitals/**").hasAnyAuthority("admin", "guest") to anyone
						// laboratories
						.antMatchers(HttpMethod.POST, "/laboratories/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/laboratories/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/laboratories/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/laboratories/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/laboratories/**").hasAnyAuthority("admin", "guest")
						// .antMatchers("/auth-needed/**").authenticated()
						// .antMatchers("/noauth-public/**").permitAll()
						// .antMatchers("/admin/**").hasAuthority("admin")
						// age types
						.antMatchers(HttpMethod.PUT, "/agetypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/agetypes/**").hasAnyAuthority("admin", "guest")
						// disease types
						.antMatchers(HttpMethod.POST, "/diseasetypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/diseasetypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/diseasetypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/diseasetypes/**").hasAnyAuthority("admin", "guest")
						// opd
						.antMatchers(HttpMethod.POST, "/opds/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/opds/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/opds/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/opds/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/opds/**").hasAnyAuthority("admin", "guest")
						// operations
						.antMatchers(HttpMethod.POST, "/operations/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/operations/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/operations/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/operations/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/operations/**").hasAnyAuthority("admin", "guest")
						// patientvaccines
						.antMatchers(HttpMethod.POST, "/patientvaccines/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/patientvaccines/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/patientvaccines/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/patientvaccines/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/patientvaccines/**").hasAnyAuthority("admin", "guest")
						// pregnanttreatmenttypes
						.antMatchers(HttpMethod.POST, "/pregnanttreatmenttypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/pregnanttreatmenttypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/pregnanttreatmenttypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/pregnanttreatmenttypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/pregnanttreatmenttypes/**").hasAnyAuthority("admin", "guest")
						// pricelists
						.antMatchers(HttpMethod.POST, "/pricelists/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/pricelists/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/pricelists/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/pricelists/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/pricelists/**").hasAnyAuthority("admin", "guest")
						// pricesothers
						.antMatchers(HttpMethod.POST, "/pricesothers/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/pricesothers/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/pricesothers/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/pricesothers/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/pricesothers/**").hasAnyAuthority("admin", "guest")
						// operation types
						.antMatchers(HttpMethod.POST, "/operationtypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/operationtypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/operationtypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PATCH, "/operationtypes/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/operationtypes/**").hasAnyAuthority("admin", "guest")
						// diseases
						.antMatchers(HttpMethod.POST, "/diseases/**").hasAuthority("admin")
						.antMatchers(HttpMethod.PUT, "/diseases/**").hasAuthority("admin")
						.antMatchers(HttpMethod.DELETE, "/diseases/**").hasAuthority("admin")
						.antMatchers(HttpMethod.GET, "/diseases/**").hasAnyAuthority("admin", "guest")
//			.and()
//			.formLogin()
//				 .loginPage("/auth/login")
//				 .successHandler(successHandler())
//				 .failureHandler(failureHandler())
						.and().apply(securityConfigurerAdapter())
						.and().httpBasic()
						.and().logout().logoutUrl("/auth/logout").addLogoutHandler(customLogoutHandler).permitAll();
		return http.build();
	}

	private JWTConfigurer securityConfigurerAdapter() {
		return new JWTConfigurer(tokenProvider);
	}

	@Bean
	public SimpleUrlAuthenticationFailureHandler failureHandler() {
		return new SimpleUrlAuthenticationFailureHandler();
	}

	@Bean
	public SimpleUrlAuthenticationSuccessHandler successHandler() {
		return new OHSimpleUrlAuthenticationSuccessHandler(tokenProvider);
	}

	private SecurityExpressionHandler<FilterInvocation> webExpressionHandler() {
		DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
		defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchy());
		return defaultWebSecurityExpressionHandler;
	}

	@Bean
	public RoleHierarchy roleHierarchy() {
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		String hierarchy = "ROLE_ADMIN > ROLE_FAMILYMANAGER \n ROLE_FAMILYMANAGER > ROLE_USER";
		roleHierarchy.setHierarchy(hierarchy);
		return roleHierarchy;
	}
}
