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

import com.github.owly7.corsionline.database.entity.Lezione;
import com.github.owly7.corsionline.database.service.LezioneService;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("/lezione")
public class LezioneController {
    @Autowired
    private LezioneService lezioneService;

    @PostMapping("/save")
    public Lezione save(@RequestBody Lezione entity) {
        return lezioneService.save(entity);
    }

    @GetMapping("/all")
    public List<Lezione> findAll() {
        return lezioneService.findAll();
    }

    @GetMapping("/get")
    public Lezione findById(@RequestParam Long id) {
        return lezioneService.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        lezioneService.deleteById(id);
    }
}
