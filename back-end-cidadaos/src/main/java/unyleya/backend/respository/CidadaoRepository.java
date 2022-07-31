/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package unyleya.backend.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unyleya.backend.cidadaos.model.Cidadao;

/**
 *
 * @author muril
 */
@Repository
public interface CidadaoRepository extends JpaRepository<Cidadao, Long>{
    
}
