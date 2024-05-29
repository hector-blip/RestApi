package com.example.gestion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Superviser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date debutSupervis;
    private Date finSupervis;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDebutSupervis() {
        return debutSupervis;
    }

    public void setDebutSupervis(Date debutSupervis) {
        this.debutSupervis = debutSupervis;
    }

    public Date getFinSupervis() {
        return finSupervis;
    }

    public void setFinSupervis(Date finSupervis) {
        this.finSupervis = finSupervis;
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
