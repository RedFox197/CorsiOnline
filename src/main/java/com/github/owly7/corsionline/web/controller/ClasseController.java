package com.github.owly7.corsionline.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.owly7.corsionline.database.entity.Classe;
import com.github.owly7.corsionline.database.service.ClasseService;
import com.github.owly7.corsionline.web.Views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/classe")
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    @JsonView(Views.Classe.Completa.class)
    @PostMapping("/save")
    public Classe save(@RequestBody Classe entity) {
        return classeService.save(entity);
    }

    @JsonView(Views.Classe.Completa.class)
    @GetMapping("/all")
    public List<Classe> findAll() {
        return classeService.findAll();
    }

    @JsonView(Views.Classe.Completa.class)
    @GetMapping("/get")
    public Classe findById(@RequestParam Long id) {
        return classeService.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        classeService.deleteById(id);
    }

}
