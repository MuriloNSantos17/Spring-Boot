/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unyleya.example.backendcidadaos.controller;

import java.util.List;
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
import unyleya.example.backendcidadaos.model.Cidadao;
import unyleya.example.backendcidadaos.repository.CidadaoRepository;

/**
 *
 * @author muril
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CidadaoController {
    @Autowired
    private CidadaoRepository cidadaoRepository;
    
    @PostMapping("/cidadaos")
    public Cidadao createCidadao(@Valid @RequestBody Cidadao cidadao){
        return cidadaoRepository.save(cidadao);
    }
    
    @GetMapping("/cidadaos")
    public List<Cidadao> getAllCidadaos(){
        return cidadaoRepository.findAll();
    }
    
    @GetMapping("/cidadaos/{id}")
    public ResponseEntity<Cidadao> getCidadaoById(@PathVariable(value="id") long id)
    {
        Optional<Cidadao> cidadao = cidadaoRepository.findById(id);
        
        if(cidadao.isPresent())
        {
            return new ResponseEntity<>(cidadao.get(),HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/cidadaos/{id}")
    public ResponseEntity<Cidadao> updateCidadado(@PathVariable(value="id") Long cidadaoId, 
    @Valid @RequestBody Cidadao newCidadao)
    {
        Optional<Cidadao> oldCidadao = cidadaoRepository.findById(cidadaoId);
        
        if(oldCidadao.isPresent())
        {
            Cidadao cidadao = oldCidadao.get();
            
            cidadao.setNome(newCidadao.getNome());
            cidadao.setCpf(newCidadao.getCpf()); 
            cidadao.setEndereco(newCidadao.getEndereco()); 
            cidadao.setSexo(newCidadao.getSexo());
            
            cidadaoRepository.save(cidadao);
            
            return new ResponseEntity<Cidadao>(cidadao,HttpStatus.OK);
        }
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/cidadaos/{id}")
    public ResponseEntity<Object> deleteCidadao( @PathVariable(value="id") Long cidadaoId) 
    {
        Optional<Cidadao> cidadao = cidadaoRepository.findById(cidadaoId);
        
        if(cidadao.isPresent())
        {
            cidadaoRepository.delete(cidadao.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
