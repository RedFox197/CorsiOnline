package com.github.owly7.corsionline.database.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Esame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo se vuoi enum
    @Column(length = 64)
    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String descrizione;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private float punteggio;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Classe classe;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Utente studente;
}
