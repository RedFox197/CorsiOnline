package com.github.owly7.fantarobot.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.fantarobot.database.entity.Esame;
import com.github.owly7.fantarobot.database.repository.EsameRepo;

@Service
public class EsameService {

    @Autowired
    private EsameRepo esameRepo;

    public void save(Esame esame) {
        esameRepo.save(esame);
    }

    public void delete(Esame esame) {
        esameRepo.delete(esame);
    }

    public List<Esame> findAll() {
        return esameRepo.findAll();
    }

    public Esame findById (Long id) {
        return esameRepo.findById(id).orElse(null);
    }


}
