package com.example.gestion.services;

import com.example.gestion.model.Superviseur;
import com.example.gestion.repository.SuperviseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperviseurService {

    @Autowired
    private SuperviseurRepository superviseurRepository;

    public List<Superviseur> getAllSuperviseurs() {
        return superviseurRepository.findAll();
    }

    public Superviseur getSuperviseurById(Long id) {
        return superviseurRepository.findById(id).orElse(null);
    }

    public Superviseur createSuperviseur(Superviseur superviseur) {
        return superviseurRepository.save(superviseur);
    }

    public Superviseur updateSuperviseur(Long id, Superviseur superviseurDetails) {
        Superviseur superviseur = superviseurRepository.findById(id).orElse(null);
        if (superviseur == null) {
            return null;
        }
        superviseur.setNom(superviseurDetails.getNom());
        superviseur.setEmail(superviseurDetails.getEmail());
        // Mettez à jour les autres champs nécessaires
        return superviseurRepository.save(superviseur);
    }

    public void deleteSuperviseur(Long id) {
        superviseurRepository.deleteById(id);
    }
}
