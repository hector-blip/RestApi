package com.example.gestion.repository;

import com.example.gestion.model.Superviser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperviserRepository extends JpaRepository<Superviser, Long> {
    
}
