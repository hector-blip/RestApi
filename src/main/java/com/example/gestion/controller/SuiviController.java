package com.example.gestion.controller;

import com.example.gestion.model.Suivi;
import com.example.gestion.services.SuiviService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suivis")
public class SuiviController {

    @Autowired
    private SuiviService suiviService;

    @GetMapping
    public List<Suivi> getAllSuivis() {
        return suiviService.getAllSuivis();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suivi> getSuiviById(@PathVariable Long id) {
        Suivi suivi = suiviService.getSuiviById(id);
        if (suivi == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(suivi);
    }

    @PostMapping
    public Suivi createSuivi(@RequestBody Suivi suivi) {
        return suiviService.createSuivi(suivi);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suivi> updateSuivi(@PathVariable Long id, @RequestBody Suivi suiviDetails) {
        Suivi updatedSuivi = suiviService.updateSuivi(id, suiviDetails);
        if (updatedSuivi == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSuivi);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuivi(@PathVariable Long id) {
        suiviService.deleteSuivi(id);
        return ResponseEntity.noContent().build();
    }
}
