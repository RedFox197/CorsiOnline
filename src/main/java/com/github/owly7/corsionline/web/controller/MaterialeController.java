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

import com.fasterxml.jackson.annotation.JsonView;
import com.github.owly7.corsionline.database.entity.Materiale;
import com.github.owly7.corsionline.database.service.MaterialeService;
import com.github.owly7.corsionline.web.Views;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/materiale")
public class MaterialeController {
    @Autowired
    private MaterialeService materialeService;

    @JsonView(Views.Materiale.Completa.class)
    @PostMapping("/save")
    public Materiale save(@RequestBody Materiale entity) {
        return materialeService.save(entity);
    }

    @JsonView(Views.Materiale.Completa.class)
    @GetMapping("/all")
    public List<Materiale> findAll() {
        return materialeService.findAll();
    }

    @JsonView(Views.Materiale.Completa.class)
    @GetMapping("/get")
    public Materiale findById(@RequestParam Long id) {
        return materialeService.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        materialeService.deleteById(id);
    }
}
