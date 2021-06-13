/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroFuncionarios.repository;

import br.com.cadastroFuncionarios.model.Funcionario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author felip
 */
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{
    
}
