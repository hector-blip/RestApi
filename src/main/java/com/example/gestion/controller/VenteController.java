package com.example.gestion.controller;

import com.example.gestion.model.Vente;
import com.example.gestion.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventes")
public class VenteController {

    @Autowired
    private VenteService venteService;

    @GetMapping
    public List<Vente> getAllVentes() {
        return venteService.getAllVentes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vente> getVenteById(@PathVariable Long id) {
        Vente vente = venteService.getVenteById(id);
        if (vente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vente);
    }

    @PostMapping
    public Vente createVente(@RequestBody Vente vente) {
        return venteService.createVente(vente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vente> updateVente(@PathVariable Long id, @RequestBody Vente venteDetails) {
        Vente updatedVente = venteService.updateVente(id, venteDetails);
        if (updatedVente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVente(@PathVariable Long id) {
        venteService.deleteVente(id);
        return ResponseEntity.noContent().build();
    }
}
