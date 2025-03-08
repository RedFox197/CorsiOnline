package com.github.owly7.corsionline.database.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

    private int punteggio;
    private LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER)
    private Classe classe;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Utente> studenti;
}
