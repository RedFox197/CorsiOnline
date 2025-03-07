package com.github.owly7.corsionline.database.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.owly7.corsionline.web.Views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@JsonView(Views.Base.class)
@Entity
public class Lezione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titolo;

    @Column(columnDefinition = "TEXT")
    private String descrizione;

    @JsonView(Views.Lezione.Completa.class)
    @ManyToOne(fetch = FetchType.EAGER)
    private Classe classe;

    //TODO mettere il mapped by in materiale FORSE
    @JsonView(Views.Lezione.Completa.class)
    @ManyToMany(mappedBy = "lezioni", fetch = FetchType.EAGER)
    private List<Materiale> materiali;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public List<Materiale> getMateriali() {
        return materiali;
    }

    public void setMateriali(List<Materiale> materiali) {
        this.materiali = materiali;
    }

}
