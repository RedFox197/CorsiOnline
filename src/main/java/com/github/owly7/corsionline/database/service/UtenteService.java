package com.github.owly7.corsionline.database.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Classe;
import com.github.owly7.corsionline.database.entity.Utente;
import com.github.owly7.corsionline.database.entity.Utente.Ruolo;
import com.github.owly7.corsionline.database.repository.ClasseRepo;
import com.github.owly7.corsionline.database.repository.UtenteRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.UtenteDTO;

import jakarta.transaction.Transactional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    @Autowired
    private ClasseRepo classeRepo;

    public void save(Utente entity) {
        utenteRepo.save(entity);
    }

    public void update(Long id, Utente utente) {
        if (!utenteRepo.existsById(id)) {
            throw new ResourceNotFoundException("Utente " + id + " non trovato! Impossibile Aggiornare");
        }

        utente.setId(id);
        utenteRepo.save(utente);
    }

    @Transactional
    public void updateClassi(Long id, List<Long> classeId, boolean delete) {
        Utente utente = findById(id);

        classeId.forEach(cId -> {
            Optional<Classe> optclasse = classeRepo.findByIdWithStudenti(cId);
            if (optclasse.isPresent()) {
                Classe classe = optclasse.get();
                if (delete)
                    //todo forse va bene buttarci solo remvoe utente
                    classe.getStudenti().removeIf(t -> t.getId().equals(id));
                else
                    classe.getStudenti().add(utente);
                classeRepo.save(classe);
            }
        });
    }

    public List<UtenteDTO> findAll() {
        return utenteRepo.findAll().stream().map(UtenteDTO::fromEntity).toList();
    }

    public Utente findById(Long id) {
        return utenteRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("utente " + id + " non trovato"));
    }

    public List<Utente> findByRuolo(String ruolo) {
        return utenteRepo.findByRuolo(Ruolo.valueOf(ruolo));
    }

    public List<UtenteDTO> findStudenteByClasseId(Long classeId) {
        return utenteRepo.findStudenteByClasseId(classeId).stream().map(UtenteDTO::fromEntity).toList();
    }

    public void deleteById(Long id) {
        utenteRepo.deleteById(id);
    }

}
