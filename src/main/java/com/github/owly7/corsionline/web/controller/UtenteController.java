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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.owly7.corsionline.database.entity.Utente;
import com.github.owly7.corsionline.database.service.ClasseService;
import com.github.owly7.corsionline.database.service.EsameService;
import com.github.owly7.corsionline.database.service.UtenteService;
import com.github.owly7.corsionline.web.dto.ClasseDTO;
import com.github.owly7.corsionline.web.dto.EsameDTO;
import com.github.owly7.corsionline.web.dto.UtenteDTO;
import com.github.owly7.corsionline.web.dto.UtenteSaveWithClassiRequest;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private ClasseService classeService;

    @Autowired
    private EsameService esameService;

    @GetMapping
    public List<UtenteDTO> findAll(@RequestParam(required = false) String ruolo) {
        if (ruolo != null && !ruolo.isBlank()) {
            return utenteService.findByRuolo(ruolo).stream().map(UtenteDTO::fromEntity).toList();
        }
        return utenteService.findAll();
    }

    @GetMapping("/{id}")
    public UtenteDTO findById(@PathVariable Long id) {
        return UtenteDTO.fromEntity(utenteService.findById(id));
    }

    @GetMapping("/{id}/classi")
    public List<ClasseDTO> getClassi(@PathVariable Long id) {
        return classeService.findByStudenteId(id);
    }

    @GetMapping("/{id}/esami")
    public List<EsameDTO> getEsami(@PathVariable Long id) {
        return esameService.findByUtenteId(id);
    }

    @PutMapping("/{id}/classi")
    public void updateClassi(
            @PathVariable Long id,
            @RequestParam(required = false, defaultValue = "false") boolean delete,
            @RequestBody List<Long> classi
    ) {
        utenteService.updateClassi(id, classi, delete);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UtenteSaveWithClassiRequest entity) {
        utenteService.saveWithClassi(entity);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Utente entity) {
        utenteService.update(id, entity);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        utenteService.deleteById(id);
    }
}
