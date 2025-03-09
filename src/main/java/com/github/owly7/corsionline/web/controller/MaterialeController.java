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

import com.github.owly7.corsionline.database.entity.lezione.Materiale;
import com.github.owly7.corsionline.database.service.MaterialeService;
import com.github.owly7.corsionline.web.dto.lezione.MaterialeDTO;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/materiali")
public class MaterialeController {
    @Autowired
    private MaterialeService materialeService;

    @GetMapping
    public List<MaterialeDTO> findAll() {
        return materialeService.findAll();
    }

    @GetMapping("/{id}")
    public MaterialeDTO findById(@PathVariable Long id) {
        return materialeService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Materiale entity) {
        materialeService.save(entity);
    }

    @PutMapping("/{id}")
    public Materiale update(@PathVariable Long id, @RequestBody Materiale entity) {
        return materialeService.update(id, entity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        materialeService.deleteById(id);
    }
}
