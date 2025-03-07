package com.github.owly7.corsionline.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.owly7.corsionline.database.entity.Corso;
import com.github.owly7.corsionline.database.service.CorsoService;
import com.github.owly7.corsionline.web.Views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/corso")
public class CorsoController {

    @Autowired
    private CorsoService corsoService;

    @JsonView(Views.Corso.Completa.class)
    @GetMapping("/all")
    public ResponseEntity<List<Corso>> findAllCorso() {
        return ResponseEntity.ok(corsoService.findAll());
    }

    @JsonView(Views.Corso.Completa.class)
    @PostMapping("/save")
    public ResponseEntity<Corso> save(@RequestBody Corso entity) {
        return ResponseEntity.ok(corsoService.save(entity));
    }
    
    @JsonView(Views.Corso.Completa.class)
    @GetMapping("/get")
    public ResponseEntity<Corso> findById(@RequestParam long id) {
        return ResponseEntity.ok(corsoService.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        corsoService.deleteById(id);
    }

}
