/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rfdouro.modeloSBWeb.modeloSBWeb.persistencia;

import br.rfdouro.modeloSBWeb.modeloSBWeb.modelo.Pessoa;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author romulo.douro
 */
public interface PessoaRepositorio extends CrudRepository<Pessoa, Long> {
 
 
 /**
  * tem que ter a nomenclatura relacionada ao atributo da class findByNome onde nome é um atributo da classe
  * @param nome
  * @return 
  */
 List<Pessoa> findByNome(String nome);

 //@Query("SELECT p FROM Pessoa p WHERE p.nome LIKE CONCAT(UPPER(:nome),'%')")
 //List<Pessoa> procuraPeloInicio(@Param("nome") String nome);
 
 /**
  * deve possuir uma query para fazer a pesquisa
  * @param nome
  * @return 
  */
 @Query("SELECT p FROM Pessoa p WHERE p.nome LIKE ?1% ")
 List<Pessoa> procuraPeloInicio(String nome);
}
