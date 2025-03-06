package com.github.owly7.fantarobot.database.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Corso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    private String titolo;
    @Column(columnDefinition = "TEXT")
    private String descrizione;

    @Column(columnDefinition = "TEXT")
    private String programma;

    // TODO tabella a parte
    @Column(columnDefinition = "TEXT")
    private String materialeDidattico;

    @ManyToMany
    @JsonBackReference
    private List<Utente> docenti = new ArrayList<>();

    public Corso() {

    }

    public Corso(String titolo, String descrizione, String programma, String materialeDidattico) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.programma = programma;
        this.materialeDidattico = materialeDidattico;
    }

    public String getProgramma() {
        return programma;
    }

    public void setProgramma(String programma) {
        this.programma = programma;
    }

    public String getMaterialeDidattico() {
        return materialeDidattico;
    }

    public void setMaterialeDidattico(String materialeDidattico) {
        this.materialeDidattico = materialeDidattico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<Utente> getDocenti() {
        return docenti;
    }

    public void setDocenti(List<Utente> docenti) {
        this.docenti = docenti;
    }
}
