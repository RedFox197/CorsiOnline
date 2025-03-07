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

@JsonView(Views.Base.class)
@Entity
public class Materiale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String url;

    @JsonView(Views.Materiale.Completa.class)
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Lezione> lezioni;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Lezione> getLezioni() {
        return lezioni;
    }

    public void setLezioni(List<Lezione> lezioni) {
        this.lezioni = lezioni;
    }

}
