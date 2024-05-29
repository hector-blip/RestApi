package com.example.gestion.controller;

import com.example.gestion.model.Approvisionnement;
import com.example.gestion.services.ApprovisionnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/approvisionnements")
public class ApprovisionnementController {

    @Autowired
    private ApprovisionnementService approvisionnementService;

    @GetMapping
    public List<Approvisionnement> getAllApprovisionnements() {
        return approvisionnementService.getAllApprovisionnements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Approvisionnement> getApprovisionnementById(@PathVariable Long id) {
        Approvisionnement approvisionnement = approvisionnementService.getApprovisionnementById(id);
        if (approvisionnement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(approvisionnement);
    }

    @PostMapping
    public Approvisionnement createApprovisionnement(@RequestBody Approvisionnement approvisionnement) {
        return approvisionnementService.createApprovisionnement(approvisionnement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Approvisionnement> updateApprovisionnement(@PathVariable Long id, @RequestBody Approvisionnement approvisionnementDetails) {
        Approvisionnement updatedApprovisionnement = approvisionnementService.updateApprovisionnement(id, approvisionnementDetails);
        if (updatedApprovisionnement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedApprovisionnement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApprovisionnement(@PathVariable Long id) {
        approvisionnementService.deleteApprovisionnement(id);
        return ResponseEntity.noContent().build();
    }
}
