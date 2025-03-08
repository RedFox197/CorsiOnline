package com.github.owly7.corsionline.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 100)
    private String cognome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Ruolo ruolo;

    @ManyToMany(mappedBy = "studenti", fetch = FetchType.EAGER)
    private List<Classe> classi;

    @ManyToMany(mappedBy = "studenti", fetch = FetchType.EAGER)
    private List<Esame> esami;

    public enum Ruolo {
        STUDENTE,
        DOCENTE,
        AMMINISTRATORE
    }
}
