package com.github.owly7.corsionline.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.owly7.corsionline.database.entity.Evento;
import com.github.owly7.corsionline.database.service.EventoService;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/evento")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @PostMapping("/save")
    public Evento save(@RequestBody Evento entity) {
        return eventoService.save(entity);
    }

    @GetMapping("/all")
    public List<Evento> findAll() {
        return eventoService.findAll();
    }

    @GetMapping("/get")
    public Evento findById(@RequestParam Long id) {
        return eventoService.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        eventoService.deleteById(id);
    }

}
