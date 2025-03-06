package com.github.owly7.corsionline.database.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Esame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64)
    private String tipo;

    @Column (length = 128)
    private String descrizione;

    private int punteggioMax;
    private LocalDate data;

    @ManyToMany
    @JsonBackReference
    private List<Classe> classi;
    @ManyToMany
    private List<Utente> studenti;

    public List<Utente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Utente> studenti) {
        this.studenti = studenti;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public int getPunteggioMax() {
        return punteggioMax;
    }
    public void setPunteggioMax(int punteggioMax) {
        this.punteggioMax = punteggioMax;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Esame [\nid=" + id + 
                ", \ntipo=" + tipo + 
                ", \ndescrizione=" + descrizione + 
                ", \npunteggioMax=" + punteggioMax + 
                ", \ndata=" + data + "]";
    }

}

