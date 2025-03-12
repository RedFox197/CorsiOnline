package com.github.owly7.corsionline.database.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataInizio;

    @Column(nullable = false)
    private LocalDate dataFine;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Corso corso;

    @ManyToOne
    private Utente docente;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.REMOVE)
    private List<Lezione> lezioni;

    @ManyToMany
    private List<Utente> studenti;

    //ignoro
    @OneToMany(mappedBy = "classe")
    private List<Esame> esami;
}
