package com.shadow.dashboard2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNota;

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long id) {
        this.idNota = id;
    }
}
