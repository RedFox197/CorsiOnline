package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Corso;
import com.github.owly7.corsionline.database.repository.ClasseRepo;
import com.github.owly7.corsionline.database.repository.CorsoRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.ClasseDTO;
import com.github.owly7.corsionline.web.dto.CorsoDTO;

@Service
public class CorsoService {
    @Autowired
    private CorsoRepo corsoRepo;

    @Autowired
    private ClasseRepo classeRepo;

    public void save(Corso entity) {
        corsoRepo.save(entity);
    }

    public Corso update(Long id, Corso corso) {
        if (!corsoRepo.existsById(id)) {
            throw new ResourceNotFoundException("Corso " + id + " non trovato! Impossibile Aggiornare");
        }

        corso.setId(id);
        return corsoRepo.save(corso);
    }

    public List<CorsoDTO> findAll() {
        return corsoRepo.findAll().stream().map(CorsoDTO::fromEntity).toList();
    }

    public CorsoDTO findById(Long id) {
        return corsoRepo.findById(id).map(CorsoDTO::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("corso " + id + " non trovato"));
    }

    public List<ClasseDTO> findClassi(Long corsoId) {
        return classeRepo.findByCorsoId(corsoId).stream().map(ClasseDTO::fromEntity).toList();
    }

    public void deleteById(Long id) {
        corsoRepo.deleteById(id);
    }

}
