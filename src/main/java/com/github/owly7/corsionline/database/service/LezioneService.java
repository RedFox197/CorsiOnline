package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.lezione.Lezione;
import com.github.owly7.corsionline.database.repository.LezioneRepo;
import com.github.owly7.corsionline.database.repository.MaterialeRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.lezione.LezioneDTO;
import com.github.owly7.corsionline.web.dto.lezione.MaterialeDTO;

@Repository
public class LezioneService {
    @Autowired
    private LezioneRepo lezioneRepo;

    @Autowired
    private MaterialeRepo materialeRepo;

    public void save(Lezione entity) {
        lezioneRepo.save(entity);
    }

    public Lezione update(Long id, Lezione lezione) {
        if (!lezioneRepo.existsById(id)) {
            throw new ResourceNotFoundException("Lezione " + id + " non trovata! Impossibile Aggiornare");
        }

        lezione.setId(id);
        return lezioneRepo.save(lezione);
    }

    public List<LezioneDTO> findAll() {
        return lezioneRepo.findAll().stream().map(LezioneDTO::fromEntity).toList();
    }

    public LezioneDTO findById(Long id) {
        return lezioneRepo.findById(id).map(LezioneDTO::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("lezione " + id + " non trovata"));
    }

    public List<MaterialeDTO> findMateriali(Long lezioneId) {
        return materialeRepo.findByLezioneId(lezioneId).stream().map(MaterialeDTO::fromEntity).toList();
    }

    public void deleteById(Long id) {
        lezioneRepo.deleteById(id);
    }

}
