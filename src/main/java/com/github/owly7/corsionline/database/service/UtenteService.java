package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Utente;
import com.github.owly7.corsionline.database.repository.UtenteRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.UtenteDTO;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public void save(Utente entity) {
        utenteRepo.save(entity);
    }

    public List<UtenteDTO> findAll() {
        return utenteRepo.findAll().stream().map(UtenteDTO::fromEntity).toList();
    }

    public UtenteDTO findById(Long id) {
        return utenteRepo.findById(id).map(UtenteDTO::fromEntity).orElseThrow(() -> new ResourceNotFoundException("utente " + id + " non trovato"));
    }

    public void deleteById(Long id) {
        utenteRepo.deleteById(id);
    }

}
