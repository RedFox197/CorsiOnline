package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.lezione.Materiale;
import com.github.owly7.corsionline.database.repository.MaterialeRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.lezione.MaterialeDTO;

@Service
public class MaterialeService {
    @Autowired
    private MaterialeRepo materialeRepo;

    public void save(Materiale entity) {
        materialeRepo.save(entity);
    }

    public Materiale update(Long id, Materiale materiale) {
        if (!materialeRepo.existsById(id)) {
            throw new ResourceNotFoundException("Materiale " + id + " non trovato! Impossibile Aggiornare");
        }

        materiale.setId(id);
        return materialeRepo.save(materiale);
    }

    public List<MaterialeDTO> findAll() {
        return materialeRepo.findAll().stream().map(MaterialeDTO::fromEntity).toList();
    }

    public MaterialeDTO findById(Long id) {
        return materialeRepo.findById(id).map(MaterialeDTO::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("materiale " + id + " non trovato"));
    }

    public void deleteById(Long id) {
        materialeRepo.deleteById(id);
    }

}
