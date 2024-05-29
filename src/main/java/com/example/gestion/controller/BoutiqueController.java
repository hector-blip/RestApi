package com.example.gestion.controller;

import com.example.gestion.model.Boutique;
import com.example.gestion.services.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boutiques")
public class BoutiqueController {

    @Autowired
    private BoutiqueService boutiqueService;

    @GetMapping
    public List<Boutique> getAllBoutiques() {
        return boutiqueService.getAllBoutiques();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boutique> getBoutiqueById(@PathVariable Long id) {
        Boutique boutique = boutiqueService.getBoutiqueById(id);
        if (boutique == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(boutique);
    }

    @PostMapping
    public Boutique createBoutique(@RequestBody Boutique boutique) {
        return boutiqueService.createBoutique(boutique);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boutique> updateBoutique(@PathVariable Long id, @RequestBody Boutique boutiqueDetails) {
        Boutique updatedBoutique = boutiqueService.updateBoutique(id, boutiqueDetails);
        if (updatedBoutique == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBoutique);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoutique(@PathVariable Long id) {
        boutiqueService.deleteBoutique(id);
        return ResponseEntity.noContent().build();
    }
}
