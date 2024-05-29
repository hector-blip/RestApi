package com.example.gestion.repository;

import com.example.gestion.model.AgentVendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentVendeurRepository extends JpaRepository<AgentVendeur, Long> {
    
}
