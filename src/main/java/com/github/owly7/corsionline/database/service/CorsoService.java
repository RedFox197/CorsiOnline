package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Corso;
import com.github.owly7.corsionline.database.repository.ClasseRepo;
import com.github.owly7.corsionline.database.repository.CorsoRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class CorsoService {
    @Autowired
    private CorsoRepo corsoRepo;

    @Autowired
    private ClasseRepo classeRepo;

    public void save(Corso entity) {
        entity.setId(null);
        corsoRepo.save(entity);
    }

    public void update(Long id, Corso corso) {
        corso.setId(id);
        corsoRepo.save(corso);
    }

    @Transactional
    public void updateClassi(Long id, List<Long> classiId, boolean delete) {
        classiId.forEach(classeId -> {
            classeRepo.updateCorsoId(classeId, delete ? null : id);
        });
    }

    public List<Corso> findAll() {
        return corsoRepo.findAll();
    }

    public Corso findById(Long id) {
        checkExists(id);
        return corsoRepo.findById(id).get();
    }

    public Corso findByIdWithClassi(Long id) {
        checkExists(id);
        return corsoRepo.findByIdWithClassi(id).get();
    }

    public void checkExists(Long id) {
        if (!corsoRepo.existsById(id)) {
            throw new ResourceNotFoundException("Corso " + id + " non trovato!");
        }
    }

    public void deleteById(Long id) {
        corsoRepo.deleteById(id);
    }

}
