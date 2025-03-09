package com.github.owly7.corsionline.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.lezione.Lezione;
import com.github.owly7.corsionline.database.repository.LezioneRepo;

@Repository
public class LezioneService {
    @Autowired
    private LezioneRepo lezioneRepo;

    public <S extends Lezione> S save(S entity) {
        return lezioneRepo.save(entity);
    }

    public List<Lezione> findAll() {
        return lezioneRepo.findAll();
    }

    public Optional<Lezione> findById(Long id) {
        return lezioneRepo.findById(id);
    }

    public void deleteById(Long id) {
        lezioneRepo.deleteById(id);
    }

}
