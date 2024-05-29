package com.example.gestion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Superviseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supervisId;
    private String nomSupervis;
    private String prenomSupervis;

    // Getters and Setters
    public Long getSupervisId() {
        return supervisId;
    }

    public void setSupervisId(Long supervisId) {
        this.supervisId = supervisId;
    }

    public String getNomSupervis() {
        return nomSupervis;
    }

    public void setNomSupervis(String nomSupervis) {
        this.nomSupervis = nomSupervis;
    }

    public String getPrenomSupervis() {
        return prenomSupervis;
    }

    public void setPrenomSupervis(String prenomSupervis) {
        this.prenomSupervis = prenomSupervis;
    }

    public Object getNom() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNom'");
    }

    public void setNom(Object nom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNom'");
    }

    public Object getEmail() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmail'");
    }

    public void setEmail(Object email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
    }
}
