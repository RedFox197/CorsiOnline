package com.github.owly7.corsionline.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.owly7.corsionline.database.entity.Classe;
import com.github.owly7.corsionline.database.entity.Esame;
import com.github.owly7.corsionline.database.entity.Evento;
import com.github.owly7.corsionline.database.entity.Utente;
import com.github.owly7.corsionline.database.entity.lezione.Lezione;
import com.github.owly7.corsionline.database.service.ClasseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/classi")
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    @GetMapping
    public List<Classe> findAll() {
        return classeService.findAll();
    }

    @GetMapping("/{id}")
    public Classe findById(@PathVariable Long id) {
        return classeService.findById(id).get();
    }

    @GetMapping("/{id}/lezioni")
    public List<Lezione> getLezioni(@PathVariable Long id) {
        return classeService.findById(id).get().getLezioni();
    }

    @GetMapping("/{id}/studenti")
    public List<Utente> getStudenti(@PathVariable Long id) {
        return classeService.findById(id).get().getStudenti();
    }

    @GetMapping("/{id}/eventi")
    public List<Evento> getEventi(@PathVariable Long id) {
        return classeService.findById(id).get().getEventi();
    }

    @GetMapping("/{id}/esami")
    public List<Esame> getEsami(@PathVariable Long id) {
        return classeService.findById(id).get().getEsami();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Classe save(@RequestBody Classe entity) {
        return classeService.save(entity);
    }

    // TODO aggiornare service con metodo update
    @PutMapping("/{id}")
    public Classe update(@PathVariable Long id, @RequestBody Classe entity) {
        entity.setId(id);
        return classeService.save(entity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        classeService.deleteById(id);
    }

}
