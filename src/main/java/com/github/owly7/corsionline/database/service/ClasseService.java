package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Classe;
import com.github.owly7.corsionline.database.repository.ClasseRepo;
import com.github.owly7.corsionline.database.repository.EsameRepo;
import com.github.owly7.corsionline.database.repository.EventoRepo;
import com.github.owly7.corsionline.database.repository.LezioneRepo;
import com.github.owly7.corsionline.database.repository.UtenteRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.ClasseDTO;
import com.github.owly7.corsionline.web.dto.EsameDTO;
import com.github.owly7.corsionline.web.dto.EventoDTO;
import com.github.owly7.corsionline.web.dto.UtenteDTO;
import com.github.owly7.corsionline.web.dto.lezione.LezioneDTO;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepo classeRepo;

    @Autowired
    private LezioneRepo lezioneRepo;

    @Autowired
    private UtenteRepo utenteRepo;

    @Autowired
    private EventoRepo eventoRepo;

    @Autowired
    private EsameRepo esameRepo;

    public void save(Classe entity) {
        classeRepo.save(entity);
    }

    public Classe update(Long id, Classe classe) {
        if (!classeRepo.existsById(id)) {
            throw new ResourceNotFoundException("Classe " + id + " non trovata! Impossibile Aggiornare");
        }

        classe.setId(id);
        return classeRepo.save(classe);
    }

    public List<ClasseDTO> findAll() {
        return classeRepo.findAll().stream().map(ClasseDTO::fromEntity).toList();
    }

    public ClasseDTO findById(Long id) {
        return classeRepo.findById(id).map(ClasseDTO::fromEntity)
                .orElseThrow(() -> new ResourceNotFoundException("classe " + id + " non trovata"));
    }

    public List<LezioneDTO> findLezioni(Long classeId) {
        return lezioneRepo.findByClasseId(classeId).stream().map(LezioneDTO::fromEntity).toList();
    }

    public List<UtenteDTO> findStudenti(Long classeId) {
        return utenteRepo.findByClasseId(classeId).stream().map(UtenteDTO::fromEntity).toList();
    }

    public List<EventoDTO> findEventi(Long classeId) {
        return eventoRepo.findByClasseId(classeId).stream().map(EventoDTO::fromEntity).toList();
    }

    public List<EsameDTO> findEsami(Long classeId) {
        return esameRepo.findByClasseId(classeId).stream().map(EsameDTO::fromEntity).toList();
    }

    public void deleteById(Long id) {
        classeRepo.deleteById(id);
    }

}
