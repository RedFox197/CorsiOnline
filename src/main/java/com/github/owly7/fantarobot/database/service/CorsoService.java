package com.github.owly7.fantarobot.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.fantarobot.database.entity.Corso;
import com.github.owly7.fantarobot.database.repository.CorsoRepo;

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

    public void delete(Corso entity) {
        corsoRepo.delete(entity);
    }

    public void deleteById(Long id) {
        corsoRepo.deleteById(id);
    }

}
