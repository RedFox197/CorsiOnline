package com.github.owly7.corsionline.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Classe;
import com.github.owly7.corsionline.database.repository.ClasseRepo;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepo classeRepo;

    public <S extends Classe> S save(S entity) {
        return classeRepo.save(entity);
    }

    public List<Classe> findAll() {
        return classeRepo.findAll();
    }

    public Optional<Classe> findById(Long id) {
        return classeRepo.findById(id);
    }

    public void deleteById(Long id) {
        classeRepo.deleteById(id);
    }

}
