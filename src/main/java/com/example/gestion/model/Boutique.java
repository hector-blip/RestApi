package com.example.gestion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Boutique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boutiqueId;
    private String nomBoutique;
    private String telBoutique;
    private String adresseBoutique;

    // Getters and Setters
    public Long getBoutiqueId() {
        return boutiqueId;
    }

    public void setBoutiqueId(Long boutiqueId) {
        this.boutiqueId = boutiqueId;
    }

    public String getNomBoutique() {
        return nomBoutique;
    }

    public void setNomBoutique(String nomBoutique) {
        this.nomBoutique = nomBoutique;
    }

    public String getTelBoutique() {
        return telBoutique;
    }

    public void setTelBoutique(String telBoutique) {
        this.telBoutique = telBoutique;
    }

    public String getAdresseBoutique() {
        return adresseBoutique;
    }

    public void setAdresseBoutique(String adresseBoutique) {
        this.adresseBoutique = adresseBoutique;
    }

    public Object getNom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNom'");
    }

    public void setNom(Object nom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNom'");
    }
}
