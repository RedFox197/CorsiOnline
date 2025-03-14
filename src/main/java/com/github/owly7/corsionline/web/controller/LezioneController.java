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

import com.github.owly7.corsionline.database.service.LezioneService;
import com.github.owly7.corsionline.web.dto.LezioneDTO;

@CrossOrigin("http://localhost:5173/")
@RestController
@RequestMapping("api/v1/lezioni")
public class LezioneController {
    @Autowired
    private LezioneService lezioneService;

    @GetMapping
    public List<LezioneDTO> findAll() {
        return lezioneService.findAll();
    }

    @GetMapping("/{id}")
    public LezioneDTO findById(@PathVariable Long id) {
        return lezioneService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody LezioneDTO entity) {
        lezioneService.save(LezioneDTO.toEntity(entity));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody LezioneDTO entity) {
        lezioneService.update(id, LezioneDTO.toEntity(entity));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        lezioneService.deleteById(id);
    }
}
