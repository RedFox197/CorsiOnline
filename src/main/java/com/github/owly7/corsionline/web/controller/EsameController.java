package com.github.owly7.corsionline.web.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.owly7.corsionline.database.entity.Esame;
import com.github.owly7.corsionline.database.entity.Esame;
import com.github.owly7.corsionline.database.service.EsameService;
import com.github.owly7.corsionline.web.Views;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/esami")
public class EsameController {

    @Autowired
    private EsameService esameService;

    @GetMapping
    public List<Esame> findAll() {
        return esameService.findAll();
    }

    @GetMapping("/{id}")
    public Esame findById(@PathVariable Long id) {
        return esameService.findById(id).get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Esame save(@RequestBody Esame entity) {
        return esameService.save(entity);
    }

    // TODO aggiornare service con metodo update
    @PutMapping("/{id}")
    public Esame update(@PathVariable Long id, @RequestBody Esame entity) {
        entity.setId(id);
        return esameService.save(entity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        esameService.deleteById(id);
    }
}