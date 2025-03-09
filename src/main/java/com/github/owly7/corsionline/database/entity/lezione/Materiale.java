package com.github.owly7.corsionline.database.entity.lezione;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Materiale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column(length = 50)
    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String url;

    @ManyToMany(mappedBy = "materiali")
    private List<Lezione> lezioni;
}
