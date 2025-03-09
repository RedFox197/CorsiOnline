package com.github.owly7.corsionline.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.owly7.corsionline.database.entity.Classe;
import com.github.owly7.corsionline.database.entity.Esame;
import com.github.owly7.corsionline.database.entity.Utente;
import com.github.owly7.corsionline.database.service.UtenteService;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public List<Utente> findAll() {
        return utenteService.findAll();
    }

    @GetMapping("/{id}")
    public Utente findById(@PathVariable Long id) {
        return utenteService.findById(id).get();
    }

    @GetMapping("/{id}/classi")
    public List<Classe> getClassi(@PathVariable Long id) {
        return utenteService.findById(id).get().getClassi();
    }

    @GetMapping("/{id}/esami")
    public List<Esame> getEsami(@PathVariable Long id) {
        return utenteService.findById(id).get().getEsami();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Utente save(@RequestBody Utente entity) {
        return utenteService.save(entity);
    }

    // TODO aggiornare service con metodo update
    @PutMapping("/{id}")
    public Utente update(@PathVariable Long id, @RequestBody Utente entity) {
        entity.setId(id);
        return utenteService.save(entity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        utenteService.deleteById(id);
    }
}
