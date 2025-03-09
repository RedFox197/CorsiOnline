package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Evento;
import com.github.owly7.corsionline.database.repository.EventoRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.EventoDTO;

@Service
public class EventoService {
    @Autowired
    private EventoRepo eventoRepo;

    public void save(Evento entity) {
        eventoRepo.save(entity);
    }

    public List<EventoDTO> findAll() {
        return eventoRepo.findAll().stream().map(EventoDTO::fromEntity).toList();
    }

    public EventoDTO findById(Long id) {
        return eventoRepo.findById(id).map(EventoDTO::fromEntity).orElseThrow(() -> new ResourceNotFoundException("evento " + id + " non trovato"));
    }

    public void deleteById(Long id) {
        eventoRepo.deleteById(id);
    }

}
