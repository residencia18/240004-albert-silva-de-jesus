// package com.swprojects.makrosales.config;

// import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
// import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
// import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Import;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

// @Configuration
// @EnableWebSecurity
// public class ActuatorConfig extends WebSecurityConfiguration {

//   private WebSecurity web;

//   protected void configure(HttpSecurity http) throws Exception {
//     http
//         .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//             .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
//             .anyRequest().authenticated());
//   }

//   public void configure(WebSecurity web) throws Exception {
//     this.web = web;
//     web.ignoring().requestMatchers("/actuator/**"); // Allow access to Actuator endpoints without authentication
//   }

// }
