package com.example.gestion.services;

import com.example.gestion.model.Vente;
import com.example.gestion.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {

    @Autowired
    private VenteRepository venteRepository;

    public List<Vente> getAllVentes() {
        return venteRepository.findAll();
    }

    public Vente getVenteById(Long id) {
        return venteRepository.findById(id).orElse(null);
    }

    public Vente createVente(Vente vente) {
        return venteRepository.save(vente);
    }

    public Vente updateVente(Long id, Vente venteDetails) {
        Vente vente = venteRepository.findById(id).orElse(null);
        if (vente == null) {
            return null;
        }
        // vente.setProduit(venteDetails.getProduit());
        vente.setQteVendue(venteDetails.getQteVendue());
        vente.setDateVente(venteDetails.getDateVente());
        // Mettez à jour les autres champs nécessaires
        return venteRepository.save(vente);
    }

    public void deleteVente(Long id) {
        venteRepository.deleteById(id);
    }
}
