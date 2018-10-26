/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rfdouro.modeloSBWeb.modeloSBWeb.config.filter;

import br.rfdouro.modeloSBWeb.modeloSBWeb.config.security.TokenAuthenticationService;
import br.rfdouro.modeloSBWeb.modeloSBWeb.modelo.AccountCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collections;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author romulo.douro
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

 public JWTLoginFilter(String url, AuthenticationManager authManager) {
  super(new AntPathRequestMatcher(url));
  setAuthenticationManager(authManager);
 }

 @Override
 public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
         throws AuthenticationException, IOException, ServletException {
  
  System.out.println("->"+request.getParameter("username"));
  System.out.println("->"+request.getParameter("password"));

  AccountCredentials credentials = new ObjectMapper()
          .readValue(request.getInputStream(), AccountCredentials.class);

  return getAuthenticationManager().authenticate(
          new UsernamePasswordAuthenticationToken(
                  credentials.getUsername(),
                  credentials.getPassword(),
                  Collections.emptyList()
          )
  );
 }

 @Override
 public void successfulAuthentication(
         HttpServletRequest request,
         HttpServletResponse response,
         FilterChain filterChain,
         Authentication auth) throws IOException, ServletException {

  TokenAuthenticationService.addAuthentication(response, auth.getName());
 }

}
