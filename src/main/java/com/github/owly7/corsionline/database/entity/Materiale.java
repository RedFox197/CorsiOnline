package com.github.owly7.corsionline.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

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

    @ManyToOne
    private Lezione lezione;
}
