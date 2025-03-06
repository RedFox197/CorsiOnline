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
import com.github.owly7.fantarobot.database.entity.Studente;
import com.github.owly7.fantarobot.database.service.StudenteService;

@RestController
@RequestMapping("/studente")
public class StudenteController {

    @Autowired
    private StudenteService studenteService;

    @GetMapping("/all")
    public ResponseEntity<List<Studente>> findAllStudente() {
        return ResponseEntity.ok(studenteService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Studente> save(@RequestBody Studente entity) {
        return ResponseEntity.ok(studenteService.save(entity));
    }

    @GetMapping("/get")
    public ResponseEntity<Studente> findById(@RequestParam long id) {
        return ResponseEntity.ok(studenteService.findById(id));
    }
    @GetMapping("/corso/{corsoId}")
    public ResponseEntity<List<Studente>> getStudentiByCorso(@PathVariable Long corsoId) {
        List<Studente> studenti = studenteService.findAllByCorso(corsoId);
        return ResponseEntity.ok(studenti);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        studenteService.deleteById(id);
    }

}
