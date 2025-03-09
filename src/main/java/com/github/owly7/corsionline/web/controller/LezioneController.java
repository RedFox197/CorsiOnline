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

import com.github.owly7.corsionline.database.entity.lezione.Lezione;
import com.github.owly7.corsionline.database.entity.lezione.Materiale;
import com.github.owly7.corsionline.database.service.LezioneService;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/lezioni")
public class LezioneController {
    @Autowired
    private LezioneService lezioneService;

    @GetMapping
    public List<Lezione> findAll() {
        return lezioneService.findAll();
    }

    @GetMapping("/{id}")
    public Lezione findById(@PathVariable Long id) {
        return lezioneService.findById(id).get();
    }

    @GetMapping("/{id}/materiali")
    public List<Materiale> getMateriali(@PathVariable Long id) {
        return lezioneService.findById(id).get().getMateriali();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Lezione save(@RequestBody Lezione entity) {
        return lezioneService.save(entity);
    }

    // TODO aggiornare service con metodo update
    @PutMapping("/{id}")
    public Lezione update(@PathVariable Long id, @RequestBody Lezione entity) {
        entity.setId(id);
        return lezioneService.save(entity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        lezioneService.deleteById(id);
    }
}
