package com.github.owly7.fantarobot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.owly7.fantarobot.database.entity.Docente;
import com.github.owly7.fantarobot.database.service.DocenteService;

@RestController
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    private DocenteService docenteService;

    @GetMapping("/all")
    public ResponseEntity<List<Docente>> findAllDocente() {
        return ResponseEntity.ok(docenteService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Docente> save(@RequestBody Docente entity) {
        return ResponseEntity.ok(docenteService.save(entity));
    }

    @GetMapping("/get")
    public ResponseEntity<Docente> findById(@RequestParam long id) {
        return ResponseEntity.ok(docenteService.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        docenteService.deleteById(id);
    }

}
