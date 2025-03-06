package com.github.owly7.corsionline.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//TODO da implementare gabriel
// classi nome un elenco di lezioni con date
/*
 * lista utenti
 * nome classe
 * lista lezioni
 * 
 * da fare anche repo, service e controller
 */
@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
