package com.github.owly7.corsionline.database.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.github.owly7.corsionline.database.entity.lezione.Lezione;

@Getter
@Setter
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataInizio;

    private LocalDate dataFine;

    @ManyToOne(fetch = FetchType.EAGER)
    private Corso corso;

    @ManyToOne(fetch = FetchType.EAGER)
    private Utente docente;

    @OneToMany(mappedBy = "classe", fetch = FetchType.EAGER)
    private List<Lezione> lezioni;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Utente> studenti;

    @OneToMany(mappedBy = "classe", fetch = FetchType.EAGER)
    private List<Evento> eventi;

    @OneToMany(mappedBy = "classe", fetch = FetchType.EAGER)
    private List<Esame> esami;
}
