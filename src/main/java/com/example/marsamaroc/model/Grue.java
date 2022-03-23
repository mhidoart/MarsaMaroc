package com.example.marsamaroc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grue {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;

    public Grue() {
    }

    public Grue(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Grue(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
