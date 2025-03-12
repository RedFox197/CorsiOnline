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

import com.github.owly7.corsionline.database.service.EsameService;
import com.github.owly7.corsionline.web.dto.EsameDTO;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/esami")
public class EsameController {

    @Autowired
    private EsameService esameService;

    @GetMapping
    public List<EsameDTO> findAll(@RequestParam(required = false) String nome,
            @RequestParam(required = false) boolean like) {
        if (nome != null) {
            return esameService.findByUtenteNome(nome, like).stream().map(EsameDTO::fromEntity).toList();
        }
        return esameService.findAll().stream().map(EsameDTO::fromEntity).toList();
    }

    @GetMapping("/{id}")
    public EsameDTO findById(@PathVariable Long id) {
        return EsameDTO.fromEntity(esameService.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody EsameDTO entity) {
        esameService.save(EsameDTO.toEntity(entity));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody EsameDTO entity) {
        esameService.update(id, EsameDTO.toEntity(entity));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        esameService.deleteById(id);
    }
}