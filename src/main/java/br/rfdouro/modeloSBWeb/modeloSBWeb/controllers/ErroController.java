/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rfdouro.modeloSBWeb.modeloSBWeb.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author romulo.douro
 */
@Controller
public class ErroController implements ErrorController {

 @RequestMapping("/error")
 @ResponseBody
 public String handleError(HttpServletRequest request) {
  Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
  Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
  return String.format("<html><body><h2>Página de erro</h2><div>Código de status: <b>%s</b></div>"
          + "<div>Exceção (mensagem): <b>%s</b></div><body></html>",
          statusCode, exception == null ? "N/A" : exception.getMessage());
 }

 @Override
 public String getErrorPath() {
  return "/error";
 }
}
