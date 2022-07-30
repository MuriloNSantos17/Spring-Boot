/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobackend.unyleya.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projetobackend.unyleya.model.Funcionario;
import projetobackend.unyleya.repository.FuncionarioRepository;

/**
 *
 * @author muril
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
    @GetMapping("/funcionarios")
    public List<Funcionario> getAllFuncionarios(){
        return funcionarioRepository.findAll();
    }
    
    /*
    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable(value="id") Long thows Resour
    */
    
    @PostMapping("/funcionarios")
    public Funcionario creaFuncionario(@Valid @RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
}
