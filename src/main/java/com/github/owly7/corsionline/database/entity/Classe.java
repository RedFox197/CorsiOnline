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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @JsonBackReference
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Utente> studenti;

    @OneToMany(mappedBy = "classe", fetch = FetchType.EAGER)
    private List<Evento> eventi;

    @OneToMany(mappedBy = "classe", fetch = FetchType.EAGER)
    private List<Esame> esami;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    public Utente getDocente() {
        return docente;
    }

    public void setDocente(Utente docente) {
        this.docente = docente;
    }

    public List<Lezione> getLezioni() {
        return lezioni;
    }

    public void setLezioni(List<Lezione> lezioni) {
        this.lezioni = lezioni;
    }

    public List<Utente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Utente> studenti) {
        this.studenti = studenti;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }

    public List<Esame> getEsami() {
        return esami;
    }

    public void setEsami(List<Esame> esami) {
        this.esami = esami;
    }

}
