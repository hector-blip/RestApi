package com.example.gestion.controller;

import com.example.gestion.model.Superviser;
import com.example.gestion.services.SuperviserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supervisions")
public class SuperviserController {

    @Autowired
    private SuperviserService superviserService;

    @GetMapping
    public List<Superviser> getAllSupervisions() {
        return superviserService.getAllSupervisions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Superviser> getSupervisionById(@PathVariable Long id) {
        Superviser supervision = superviserService.getSupervisionById(id);
        if (supervision == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(supervision);
    }

    @PostMapping
    public Superviser createSupervision(@RequestBody Superviser supervision) {
        return superviserService.createSupervision(supervision);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Superviser> updateSupervision(@PathVariable Long id, @RequestBody Superviser supervisionDetails) {
        Superviser updatedSupervision = superviserService.updateSupervision(id, supervisionDetails);
        if (updatedSupervision == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedSupervision);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupervision(@PathVariable Long id) {
        superviserService.deleteSupervision(id);
        return ResponseEntity.noContent().build();
    }
}
