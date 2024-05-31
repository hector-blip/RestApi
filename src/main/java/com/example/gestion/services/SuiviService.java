package com.example.gestion.services;

import com.example.gestion.model.Suivi;
import com.example.gestion.repository.SuiviRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuiviService {

    @Autowired
    private SuiviRepository suiviRepository;

    public List<Suivi> getAllSuivis() {
        return suiviRepository.findAll();
    }

    public Suivi getSuiviById(Long id) {
        return suiviRepository.findById(id).orElse(null);
    }

    public Suivi createSuivi(Suivi suivi) {
        return suiviRepository.save(suivi);
    }

    public Suivi updateSuivi(Long id, Suivi suiviDetails) {
        Suivi suivi = suiviRepository.findById(id).orElse(null);
        if (suivi == null) {
            return null;
        }
        // suivi.setDescription(suiviDetails.getDescription());
        suivi.setDateSuivi(suiviDetails.getDateSuivi());
        return suiviRepository.save(suivi);
    }

    public void deleteSuivi(Long id) {
        suiviRepository.deleteById(id);
    }
}
