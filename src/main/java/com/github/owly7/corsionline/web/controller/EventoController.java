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

import com.github.owly7.corsionline.database.entity.Evento;
import com.github.owly7.corsionline.database.service.EventoService;
import com.github.owly7.corsionline.web.dto.EventoDTO;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/eventi")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoDTO> findAll() {
        return eventoService.findAll();
    }

    @GetMapping("/{id}")
    public EventoDTO findById(@PathVariable Long id) {
        return eventoService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Evento entity) {
        eventoService.save(entity);
    }

    @PutMapping("/{id}")
    public Evento update(@PathVariable Long id, @RequestBody Evento entity) {
        return eventoService.update(id, entity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        eventoService.deleteById(id);
    }

}
