/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projetobackend.unyleya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projetobackend.unyleya.model.Funcionario;

/**
 *
 * @author muril
 */
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    
}
