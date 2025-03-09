package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Utente;
import com.github.owly7.corsionline.database.repository.ClasseRepo;
import com.github.owly7.corsionline.database.repository.EsameRepo;
import com.github.owly7.corsionline.database.repository.UtenteRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.ClasseDTO;
import com.github.owly7.corsionline.web.dto.EsameDTO;
import com.github.owly7.corsionline.web.dto.UtenteDTO;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    @Autowired
    private EsameRepo esameRepo;

    @Autowired
    private ClasseRepo classeRepo;

    public void save(Utente entity) {
        utenteRepo.save(entity);
    }

    public Utente update(Long id, Utente utente) {
        if (!utenteRepo.existsById(id)) {
            throw new ResourceNotFoundException("Utente " + id + " non trovato! Impossibile Aggiornare");
        }

        utente.setId(id);
        return utenteRepo.save(utente);
    }

    public List<UtenteDTO> findAll() {
        return utenteRepo.findAll().stream().map(UtenteDTO::fromEntity).toList();
    }

    public UtenteDTO findById(Long id) {
        return utenteRepo.findById(id).map(UtenteDTO::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("utente " + id + " non trovato"));
    }

    public List<ClasseDTO> findClassi(Long utenteId) {
        return classeRepo.findByStudenteId(utenteId).stream().map(ClasseDTO::fromEntity).toList();
    }

    public List<EsameDTO> findEsami(Long utenteId) {
        return esameRepo.findByUtenteId(utenteId).stream().map(EsameDTO::fromEntity).toList();
    }

    public void deleteById(Long id) {
        utenteRepo.deleteById(id);
    }

}
