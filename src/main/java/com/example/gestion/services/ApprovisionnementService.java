package com.example.gestion.services;

import com.example.gestion.model.Approvisionnement;
import com.example.gestion.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {

    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;

    public List<Approvisionnement> getAllApprovisionnements() {
        return approvisionnementRepository.findAll();
    }

    public Approvisionnement getApprovisionnementById(Long id) {
        return approvisionnementRepository.findById(id).orElse(null);
    }

    public Approvisionnement createApprovisionnement(Approvisionnement approvisionnement) {
        return approvisionnementRepository.save(approvisionnement);
    }

    public Approvisionnement updateApprovisionnement(Long id, Approvisionnement approvisionnementDetails) {
        Approvisionnement approvisionnement = approvisionnementRepository.findById(id).orElse(null);
        if (approvisionnement == null) {
            return null;
        }
        // approvisionnement.setProduit(approvisionnementDetails.getProduit());
        approvisionnement.setQuantiteStock(approvisionnementDetails.getQuantiteStock());
        approvisionnement.setDateStock(approvisionnementDetails.getDateStock());
        return approvisionnementRepository.save(approvisionnement);
    }

    public void deleteApprovisionnement(Long id) {
        approvisionnementRepository.deleteById(id);
    }
}
