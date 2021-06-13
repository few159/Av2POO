/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cadastroFuncionarios.controller;

import java.util.Optional;
import br.com.cadastroFuncionarios.model.Funcionario;
import br.com.cadastroFuncionarios.repository.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author felip
 * 
 */

@Controller
public class FuncionarioController {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/gerenciarFuncionarios")
    public String listarFuncionarios(Model model) {
        model.addAttribute("listaFuncionarios", funcionarioRepository.findAll());
        return "gerenciar_funcionarios";
    }

    @GetMapping("/novoFuncionario")
    public String novoFuncionario(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "editar_funcionario";
    }

    @GetMapping("/editarFuncionario/{id}")
    public String editarFuncionario(@PathVariable("id") long idFuncionario, Model model) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(idFuncionario);
        model.addAttribute("funcionario", funcionario.get());
        return "editar_funcionario";
    }

    @PostMapping("/salvarFuncionario")
    public String salvarFuncionario(Funcionario funcionario, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_funcionario";
        }
        funcionarioRepository.save(funcionario);
        return "redirect:/gerenciarFuncionarios";
    }

    @GetMapping("/excluirFuncionario/{id}")
    public String excluirFuncionario(@PathVariable("id") long idFuncionario) {
        funcionarioRepository.deleteById(idFuncionario);
        return "redirect:/gerenciarFuncionarios";
    }
}
