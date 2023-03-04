package com.springdemo.library.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;

@Configuration
public class SecurityConfiguration {

  // filter chain
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // disable cross site request forgery
    http.csrf().disable();

//    http.authorizeHttpRequests(authorize -> authorize
//            .requestMatchers("/api/books/secure/**").authenticated())
//        .oauth2ResourceServer()
//        .jwt();

    // protect endpoints at /api/<type>/secure
    http.authorizeHttpRequests()
        .requestMatchers("/api/books/**").permitAll()
        .requestMatchers("/api/reviews/**").permitAll()
        .requestMatchers("/api/books/secure/**").authenticated()
        .and()
        .oauth2ResourceServer().jwt();

    // add CORS filter
    http.cors();

    // add content negotiation strategy
    http.setSharedObject(ContentNegotiationStrategy.class,
        new HeaderContentNegotiationStrategy());

    // force a non-empty response body for 401's to make the response friendly
    Okta.configureResourceServer401ResponseBody(http);

    return http.build();
  }
}
