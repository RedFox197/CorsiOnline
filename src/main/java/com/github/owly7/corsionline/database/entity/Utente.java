package com.github.owly7.corsionline.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

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

    @ManyToMany(mappedBy = "studenti")
    private List<Classe> classi;

    @ManyToMany(mappedBy = "studenti")
    private List<Esame> esami;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public List<Classe> getClassi() {
        return classi;
    }

    public void setClassi(List<Classe> classi) {
        this.classi = classi;
    }

    public List<Esame> getEsami() {
        return esami;
    }

    public void setEsami(List<Esame> esami) {
        this.esami = esami;
    }

    public enum Ruolo {
        STUDENTE,
        DOCENTE,
        AMMINISTRATORE
    }
}
