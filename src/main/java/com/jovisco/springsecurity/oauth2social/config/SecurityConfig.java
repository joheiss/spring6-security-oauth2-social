package com.jovisco.springsecurity.oauth2social.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  SecurityFilterChain defauSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(requests -> requests
        .requestMatchers("/secure")
        .authenticated()
        .anyRequest()
        .permitAll());

    httpSecurity.formLogin(Customizer.withDefaults());
    httpSecurity.oauth2Login(Customizer.withDefaults());

    return httpSecurity.build();
  }

  // @Bean
  // ClientRegistrationRepository clientRegistrationRepository() {
  // var github = githubClientRegistration();
  // var google = googleClientRegistration();

  // return new InMemoryClientRegistrationRepository(github, google);
  // }

  // private ClientRegistration githubClientRegistration() {
  // return CommonOAuth2Provider.GITHUB.getBuilder("github")
  // .clientId("Ov23liF4tAv3O82qvnN1")
  // .clientSecret("045773f741981ff91c2aed93979e60f253d029f0")
  // .build();
  // }

  // private ClientRegistration googleClientRegistration() {
  // return CommonOAuth2Provider.GOOGLE.getBuilder("google")
  // .clientId("xxx")
  // .clientSecret("yyy")
  // .build();
  // }

}
