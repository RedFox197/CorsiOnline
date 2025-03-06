package com.github.owly7.fantarobot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.owly7.fantarobot.database.entity.Esame;
import com.github.owly7.fantarobot.database.service.EsameService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/esame")
public class EsameController {

    @Autowired
    private EsameService esameService;

    @GetMapping("/all")
    public ResponseEntity<List<Esame>> findAllEsame() {
        return ResponseEntity.ok(esameService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Esame> save(@RequestBody Esame entity) {
        return ResponseEntity.ok(esameService.save(entity));
    }

    @GetMapping("/get")
    public ResponseEntity<Esame> findById(@RequestParam long id) {
        return ResponseEntity.ok(esameService.findById(id).get());
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        esameService.deleteById(id);
    }
}