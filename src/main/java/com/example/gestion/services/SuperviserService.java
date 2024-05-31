package com.example.gestion.services;

import com.example.gestion.model.Superviser;
import com.example.gestion.repository.SuperviserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperviserService {

    @Autowired
    private SuperviserRepository superviserRepository;

    public List<Superviser> getAllSupervisions() {
        return superviserRepository.findAll();
    }

    public Superviser getSupervisionById(Long id) {
        return superviserRepository.findById(id).orElse(null);
    }

    public Superviser createSupervision(Superviser supervision) {
        return superviserRepository.save(supervision);
    }

    public Superviser updateSupervision(Long id, Superviser supervisionDetails) {
        Superviser supervision = superviserRepository.findById(id).orElse(null);
        if (supervision == null) {
            return null;
        }
        supervision.setId(supervisionDetails.getId());
        supervision.setDebutSupervis(supervisionDetails.getDebutSupervis());
        supervision.setFinSupervis(supervisionDetails.getFinSupervis());
        return superviserRepository.save(supervision);
    }

    public void deleteSupervision(Long id) {
        superviserRepository.deleteById(id);
    }
}
