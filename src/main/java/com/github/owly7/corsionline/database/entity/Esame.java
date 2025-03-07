package com.github.owly7.corsionline.database.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Esame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String descrizione;

    private int punteggio;
    private LocalDate data;

    @ManyToOne
    private Classe classe;
    @ManyToMany
    private List<Utente> studenti;
}
