package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Lezione;
import com.github.owly7.corsionline.database.repository.LezioneRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.lezione.LezioneDTO;

@Repository
public class LezioneService {
    @Autowired
    private LezioneRepo lezioneRepo;

    public void save(Lezione entity) {
        lezioneRepo.save(entity);
    }

    public void update(Long id, Lezione lezione) {
        if (!lezioneRepo.existsById(id)) {
            throw new ResourceNotFoundException("Lezione " + id + " non trovata! Impossibile Aggiornare");
        }

        lezione.setId(id);
        lezioneRepo.save(lezione);
    }

    /*public void addMateriali(Long id, List<MaterialeDTO> materialiIn) {
        Lezione lezione = lezioneRepo.findByIdWithMateriali(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lezione " + id + " non trovata! Impossibile Aggiornare"));
        
        List<Materiale> materiali = lezione.getMateriali();
        if (materiali != null) {
            materiali.addAll(materialiIn.stream().map(MaterialeDTO::toEntity).toList());
        } else {
            materiali = materialiIn.stream().map(MaterialeDTO::toEntity).toList();
        }

        lezioneRepo.save(lezione);
    }*/

    public List<LezioneDTO> findAll() {
        return lezioneRepo.findAll().stream().map(LezioneDTO::fromEntity).toList();
    }

    public LezioneDTO findById(Long id) {
        return lezioneRepo.findById(id).map(LezioneDTO::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("lezione " + id + " non trovata"));
    }

    public List<LezioneDTO> findByClasseId(Long classeId) {
        return lezioneRepo.findByClasseId(classeId).stream().map(LezioneDTO::fromEntity).toList();
    }

    public void deleteById(Long id) {
        lezioneRepo.deleteById(id);
    }

}
