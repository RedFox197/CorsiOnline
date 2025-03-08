package com.github.owly7.corsionline.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.owly7.corsionline.database.entity.Classe;
import com.github.owly7.corsionline.database.entity.Corso;
import com.github.owly7.corsionline.database.service.CorsoService;
import com.github.owly7.corsionline.web.Views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/corsi")
public class CorsoController {

    @Autowired
    private CorsoService corsoService;

    @GetMapping
    public List<Corso> findAll() {
        return corsoService.findAll();
    }

    @GetMapping("/{id}")
    public Corso findById(@PathVariable Long id) {
        return corsoService.findById(id).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Corso save(@RequestBody Corso entity) {
        return corsoService.save(entity);
    }

    // TODO aggiornare service con metodo update
    @PutMapping("/{id}")
    public Corso update(@PathVariable Long id, @RequestBody Corso entity) {
        entity.setId(id);
        return corsoService.save(entity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        corsoService.deleteById(id);
    }

}
