package com.github.owly7.corsionline.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.owly7.corsionline.database.entity.Classe;
import com.github.owly7.corsionline.database.service.ClasseService;
import com.github.owly7.corsionline.database.service.LezioneService;
import com.github.owly7.corsionline.database.service.UtenteService;
import com.github.owly7.corsionline.web.dto.ClasseDTO;
import com.github.owly7.corsionline.web.dto.UtenteDTO;
import com.github.owly7.corsionline.web.dto.lezione.LezioneDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/classi")
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    @Autowired
    private LezioneService lezioneService;

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public List<ClasseDTO> findAll() {
        return classeService.findAll();
    }

    @GetMapping("/{id}")
    public ClasseDTO findById(@PathVariable Long id) {
        return classeService.findById(id);
    }

    @GetMapping("/{id}/lezioni")
    public List<LezioneDTO> getLezioni(@PathVariable Long id) {
        return lezioneService.findByClasseId(id);
    }

    @GetMapping("/{id}/studenti")
    public List<UtenteDTO> getStudenti(@PathVariable Long id) {
        return utenteService.findStudenteByClasseId(id);
    }

    @PutMapping("/{id}/studenti")
    public void addStudenti(@PathVariable Long id, @RequestBody List<UtenteDTO> studenti) {
        classeService.addStudenti(id, studenti);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Classe entity) {
        classeService.save(entity);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Classe entity) {
        classeService.update(id, entity);
    }

    @PutMapping("/{id}/corso")
    public void setCorso(@PathVariable Long id, @RequestParam(name = "id", required = false) Long corsoId) {
        classeService.setCorso(id, corsoId);
    }

    @PutMapping("/{id}/docente")
    public void setDocente(@PathVariable Long id, @RequestParam(name = "id", required = false) Long utenteId) {
        classeService.setDocente(id, utenteId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        classeService.deleteById(id);
    }

}
