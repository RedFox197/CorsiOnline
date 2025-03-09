package com.github.owly7.corsionline.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.lezione.Materiale;
import com.github.owly7.corsionline.database.repository.MaterialeRepo;

@Service
public class MaterialeService {
    @Autowired
    private MaterialeRepo materialeRepo;

    public <S extends Materiale> S save(S entity) {
        return materialeRepo.save(entity);
    }

    public List<Materiale> findAll() {
        return materialeRepo.findAll();
    }

    public Optional<Materiale> findById(Long id) {
        return materialeRepo.findById(id);
    }

    public void deleteById(Long id) {
        materialeRepo.deleteById(id);
    }

}
