/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unyleya.example.backendcidadaos.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public List<Cidadao> getAllFuncionarios(){
        return cidadaoRepository.findAll();
    }
    
}