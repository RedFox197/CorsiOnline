package com.github.owly7.corsionline.database.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.github.owly7.corsionline.database.entity.lezione.Lezione;

@AllArgsConstructor
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

    private LocalDate dataFine;

    @ManyToOne
    private Corso corso;

    @ManyToOne
    private Utente docente;

    @OneToMany(mappedBy = "classe")
    private List<Lezione> lezioni;

    @ManyToMany
    private List<Utente> studenti;

    @OneToMany(mappedBy = "classe")
    private List<Esame> esami;
}
