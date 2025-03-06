package com.github.owly7.fantarobot.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.fantarobot.database.entity.Esame;
import com.github.owly7.fantarobot.database.repository.EsameRepo;

@Service
public class EsameService {

    @Autowired
    private EsameRepo esameRepo;

    public Esame save(Esame entity) {
        return esameRepo.save(entity);
    }

    public void delete(Esame esame) {
        esameRepo.delete(esame);
    }

    public List<Esame> findAll() {
        return esameRepo.findAll();
    }

    public Optional<Esame> findById (Long id) {
        return esameRepo.findById(id);
    }

    public void deleteById(Long id) {
        esameRepo.deleteById(id);
    }

}
