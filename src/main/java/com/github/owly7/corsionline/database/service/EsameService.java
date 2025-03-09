package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Esame;
import com.github.owly7.corsionline.database.repository.EsameRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.EsameDTO;

@Service
public class EsameService {

    @Autowired
    private EsameRepo esameRepo;

    public void save(Esame entity) {
        esameRepo.save(entity);
    }

    public void update(Long id, Esame esame) {
        if (!esameRepo.existsById(id)) {
            throw new ResourceNotFoundException("Esame " + id + " non trovato! Impossibile Aggiornare");
        }

        esame.setId(id);
        esameRepo.save(esame);
    }

    public List<EsameDTO> findAll() {
        return esameRepo.findAll().stream().map(EsameDTO::fromEntity).toList();
    }

    public EsameDTO findById(Long id) {
        return esameRepo.findById(id).map(EsameDTO::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("Esame " + id + " non trovato"));
    }

    public List<EsameDTO> findByClasseId(Long classeId) {
        return esameRepo.findByClasseId(classeId).stream().map(EsameDTO::fromEntity).toList();
    }

    public List<EsameDTO> findByUtenteId(Long utenteId) {
        return esameRepo.findByUtenteId(utenteId).stream().map(EsameDTO::fromEntity).toList();
    }

    public void deleteById(Long id) {
        esameRepo.deleteById(id);
    }
}
