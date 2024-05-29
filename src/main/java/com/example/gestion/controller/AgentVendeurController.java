package com.example.gestion.controller;

import com.example.gestion.model.AgentVendeur;
import com.example.gestion.services.AgentVendeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agents")
public class AgentVendeurController {

    @Autowired
    private AgentVendeurService agentVendeurService;

    @GetMapping
    public List<AgentVendeur> getAllAgents() {
        return agentVendeurService.getAllAgents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgentVendeur> getAgentById(@PathVariable Long id) {
        AgentVendeur agent = agentVendeurService.getAgentById(id);
        if (agent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agent);
    }

    @PostMapping
    public AgentVendeur createAgent(@RequestBody AgentVendeur agent) {
        return agentVendeurService.createAgent(agent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgentVendeur> updateAgent(@PathVariable Long id, @RequestBody AgentVendeur agentDetails) {
        AgentVendeur updatedAgent = agentVendeurService.updateAgent(id, agentDetails);
        if (updatedAgent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAgent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgent(@PathVariable Long id) {
        agentVendeurService.deleteAgent(id);
        return ResponseEntity.noContent().build();
    }
}
