package com.github.owly7.corsionline.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.owly7.corsionline.database.entity.Utente;
import com.github.owly7.corsionline.database.service.UtenteService;
import com.github.owly7.corsionline.web.Views;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/utente")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @JsonView(Views.Utente.Completa.class)
    @GetMapping("/all")
    public ResponseEntity<List<Utente>> findAllUtente() {
        return ResponseEntity.ok(utenteService.findAll());
    }

    @JsonView(Views.Utente.Completa.class)
    @PostMapping("/save")
    public ResponseEntity<Utente> save(@RequestBody Utente entity) {
        return ResponseEntity.ok(utenteService.save(entity));
    }

    @JsonView(Views.Utente.Completa.class)
    @GetMapping("/get")
    public ResponseEntity<Utente> findById(@RequestParam long id) {
        return ResponseEntity.ok(utenteService.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        utenteService.deleteById(id);
    }

}
