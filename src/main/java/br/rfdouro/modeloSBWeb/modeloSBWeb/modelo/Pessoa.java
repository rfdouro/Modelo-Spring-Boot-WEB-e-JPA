/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rfdouro.modeloSBWeb.modeloSBWeb.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author romulo.douro
 */
@Entity
public class Pessoa {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 private String nome;

 public Long getid() {
  return id;
 }

 public void setid(Long id) {
  this.id = id;
 }

 public String getNome() {
  return nome;
 }

 public void setNome(String nome) {
  this.nome = nome;
 }

 public Pessoa(String nome) {
  this.nome = nome;
 }

 public Pessoa() {
 }
 
 
 
 
 
}
