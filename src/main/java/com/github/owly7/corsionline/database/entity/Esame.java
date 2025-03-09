package com.github.owly7.corsionline.database.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Esame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String descrizione;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private float punteggio;
    
    private LocalDate data;

    @ManyToOne
    private Classe classe;

    @ManyToOne
    private Utente studente;
}
