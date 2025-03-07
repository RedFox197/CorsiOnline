package com.github.owly7.corsionline.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Evento;
import com.github.owly7.corsionline.database.repository.EventoRepo;

@Service
public class EventoService {
    @Autowired
    private EventoRepo eventoRepo;

    public <S extends Evento> S save(S entity) {
        return eventoRepo.save(entity);
    }

    public List<Evento> findAll() {
        return eventoRepo.findAll();
    }

    public Optional<Evento> findById(Long id) {
        return eventoRepo.findById(id);
    }

    public void deleteById(Long id) {
        eventoRepo.deleteById(id);
    }

}
