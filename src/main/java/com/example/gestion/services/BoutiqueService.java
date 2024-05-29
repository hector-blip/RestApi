package com.example.gestion.services;

import com.example.gestion.model.Boutique;
import com.example.gestion.repository.BoutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoutiqueService {

    @Autowired
    private BoutiqueRepository boutiqueRepository;

    public List<Boutique> getAllBoutiques() {
        return boutiqueRepository.findAll();
    }

    public Boutique getBoutiqueById(Long id) {
        return boutiqueRepository.findById(id).orElse(null);
    }

    public Boutique createBoutique(Boutique boutique) {
        return boutiqueRepository.save(boutique);
    }

    public Boutique updateBoutique(Long id, Boutique boutiqueDetails) {
        Boutique boutique = boutiqueRepository.findById(id).orElse(null);
        if (boutique == null) {
            return null;
        }
        boutique.setNom(boutiqueDetails.getNom());
        boutique.setAdresseBoutique(boutiqueDetails.getAdresseBoutique());
        // Mettez à jour les autres champs nécessaires
        return boutiqueRepository.save(boutique);
    }

    public void deleteBoutique(Long id) {
        boutiqueRepository.deleteById(id);
    }
}
