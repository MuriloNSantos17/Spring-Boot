/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobackend.unyleya.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    //https://www.treinaweb.com.br/blog/criando-uma-api-rest-com-o-spring-boot
    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable(value="id") long id)
    {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        
        if(funcionario.isPresent())
        {
            return new ResponseEntity<Funcionario>(funcionario.get(),HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/funcionarios")
    public Funcionario creaFuncionario(@Valid @RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
    
    //https://www.treinaweb.com.br/blog/criando-uma-api-rest-com-o-spring-boot
    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Object> deleteFuncionario( @PathVariable(value="id") Long funcionarioId) 
    {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(funcionarioId);
        
        if(funcionario.isPresent())
        {
            funcionarioRepository.delete(funcionario.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //https://www.treinaweb.com.br/blog/criando-uma-api-rest-com-o-spring-boot
    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> updateFuncionario(@PathVariable(value="id") Long funcionarioId, 
    @Valid @RequestBody Funcionario newFuncionario)
    {
        Optional<Funcionario> oldFuncionario = funcionarioRepository.findById(funcionarioId);
        
        if(oldFuncionario.isPresent())
        {
            Funcionario funcionario = oldFuncionario.get();
            
            funcionario.setNome(newFuncionario.getNome());
            funcionario.setSobrenome(newFuncionario.getSobrenome());
            funcionario.setEmail(newFuncionario.getEmail());            
            funcionarioRepository.save(funcionario);
            
            return new ResponseEntity<Funcionario>(funcionario,HttpStatus.OK);
        }
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
