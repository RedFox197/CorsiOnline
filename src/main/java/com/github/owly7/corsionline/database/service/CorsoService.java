package com.github.owly7.corsionline.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Corso;
import com.github.owly7.corsionline.database.repository.CorsoRepo;

@Service
public class CorsoService {
    @Autowired
    private CorsoRepo corsoRepo;

    public Corso save(Corso entity) {
        return corsoRepo.save(entity);
    }

    public List<Corso> findAll() {
        return corsoRepo.findAll();
    }

    public Optional<Corso> findById(Long id) {
        return corsoRepo.findById(id);
    }

    public void deleteById(Long id) {
        corsoRepo.deleteById(id);
    }

}
