/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rfdouro.modeloSBWeb.modeloSBWeb.config;

import br.rfdouro.modeloSBWeb.modeloSBWeb.config.filter.JWTAuthenticationFilter;
import br.rfdouro.modeloSBWeb.modeloSBWeb.config.filter.JWTLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author romulo.douro
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Override
 public void configure(HttpSecurity httpSecurity) throws Exception {
  httpSecurity.csrf().disable().authorizeRequests()
          .antMatchers("/home").permitAll()
          .antMatchers(HttpMethod.POST, "/login").permitAll()
          .antMatchers("/libs/**").permitAll()
          .antMatchers("/pessoa/**").permitAll()
          .antMatchers("/ws/pessoa").authenticated()
          .anyRequest().authenticated()
          .and()
          // filtra requisições de login
          .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
                  UsernamePasswordAuthenticationFilter.class)
          // filtra outras requisições para verificar a presença do JWT no header
          .addFilterBefore(new JWTAuthenticationFilter(),
                  UsernamePasswordAuthenticationFilter.class);
  //httpSecurity.authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
 }

 @Override
 public void configure(AuthenticationManagerBuilder auth) throws Exception {
  // cria uma conta default
  auth.inMemoryAuthentication()
          .withUser("admin")
          .password("password")
          .roles("ADMIN");
 }

 @SuppressWarnings("deprecation")
 @Bean
 public static NoOpPasswordEncoder passwordEncoder() {
  return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
 }
}
