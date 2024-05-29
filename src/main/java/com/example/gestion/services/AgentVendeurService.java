package com.example.gestion.services;

import com.example.gestion.model.AgentVendeur;
import com.example.gestion.repository.AgentVendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentVendeurService {

    @Autowired
    private AgentVendeurRepository agentVendeurRepository;

    public List<AgentVendeur> getAllAgents() {
        return agentVendeurRepository.findAll();
    }

    public AgentVendeur getAgentById(Long id) {
        return agentVendeurRepository.findById(id).orElse(null);
    }

    public AgentVendeur createAgent(AgentVendeur agent) {
        return agentVendeurRepository.save(agent);
    }

    public AgentVendeur updateAgent(Long id, AgentVendeur agentDetails) {
        AgentVendeur agent = agentVendeurRepository.findById(id).orElse(null);
        if (agent == null) {
            return null;
        }
        agent.setNomAgent(agentDetails.getNomAgent());
        agent.setEmail(agentDetails.getEmail());
        // Mettez à jour les autres champs nécessaires
        return agentVendeurRepository.save(agent);
    }

    public void deleteAgent(Long id) {
        agentVendeurRepository.deleteById(id);
    }
}
