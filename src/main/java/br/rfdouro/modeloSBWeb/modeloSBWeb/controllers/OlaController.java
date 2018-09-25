/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rfdouro.modeloSBWeb.modeloSBWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author romulo.douro
 */
@Controller
public class OlaController {

 @GetMapping("/ola")
 public String page(@RequestParam(name = "nome", required = false, defaultValue = "World") String nome, Model model) {
  model.addAttribute("nome", nome);
  return "ola";
 }

}
