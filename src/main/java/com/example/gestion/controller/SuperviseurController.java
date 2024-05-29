package com.example.gestion.controller;

import com.example.gestion.model.Superviseur;
import com.example.gestion.services.SuperviseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/superviseurs")
public class SuperviseurController {

    @Autowired
    private SuperviseurService superviseurService;

    @GetMapping
    public List<Superviseur> getAllSuperviseurs() {
        return superviseurService.getAllSuperviseurs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Superviseur> getSuperviseurById(@PathVariable Long id) {
        Superviseur superviseur = superviseurService.getSuperviseurById(id);
        if (superviseur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(superviseur);
    }

    @PostMapping
    public Superviseur createSuperviseur(@RequestBody Superviseur superviseur) {
        return superviseurService.createSuperviseur(superviseur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Superviseur> updateSuperviseur(@PathVariable Long id, @RequestBody Superviseur superviseurDetails) {
        Superviseur updatedSuperviseur = superviseurService.updateSuperviseur(id, superviseurDetails);
        if (updatedSuperviseur == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSuperviseur);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuperviseur(@PathVariable Long id) {
        superviseurService.deleteSuperviseur(id);
        return ResponseEntity.noContent().build();
    }
}
