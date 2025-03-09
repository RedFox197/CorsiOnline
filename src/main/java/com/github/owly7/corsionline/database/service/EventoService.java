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

    public void update(Long id, Evento evento) {
        if (!eventoRepo.existsById(id)) {
            throw new ResourceNotFoundException("Evento " + id + " non trovato! Impossibile Aggiornare");
        }

        evento.setId(id);
        eventoRepo.save(evento);
    }

    public List<EventoDTO> findAll() {
        return eventoRepo.findAll().stream().map(EventoDTO::fromEntity).toList();
    }

    public EventoDTO findById(Long id) {
        return eventoRepo.findById(id).map(EventoDTO::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("evento " + id + " non trovato"));
    }

    public List<EventoDTO> findByClasseId(Long classeId) {
        return eventoRepo.findByClasseId(classeId).stream().map(EventoDTO::fromEntity).toList();
    }

    public void deleteById(Long id) {
        eventoRepo.deleteById(id);
    }

}
