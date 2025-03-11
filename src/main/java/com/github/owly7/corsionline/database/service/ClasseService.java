package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Classe;
import com.github.owly7.corsionline.database.entity.Corso;
import com.github.owly7.corsionline.database.entity.Utente;
import com.github.owly7.corsionline.database.repository.ClasseRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.ClasseDTO;
import com.github.owly7.corsionline.web.dto.UtenteDTO;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepo classeRepo;

    public void save(Classe entity) {
        classeRepo.save(entity);
    }

    public void update(Long id, Classe classe) {
        if (!classeRepo.existsById(id)) {
            throw new ResourceNotFoundException("Classe " + id + " non trovata! Impossibile Aggiornare");
        }

        classe.setId(id);
        classeRepo.save(classe);
    }

    public void setCorso(Long id, Long corsoId) {
        Classe classe = getById(id);

        Corso corso = new Corso();
        corso.setId(corsoId);

        classe.setCorso(corso);
        classeRepo.save(classe);
    }

    public void setDocente(Long id, Long utenteId) {
        Classe classe = getById(id);

        Utente docente = new Utente();
        docente.setId(utenteId);

        classe.setDocente(docente);
        classeRepo.save(classe);
    }

    public void addStudenti(Long id, List<UtenteDTO> studentiIn) {
        Classe classe = classeRepo.findByIdWithStudenti(id)
                .orElseThrow(() -> new ResourceNotFoundException("classe " + id + " non trovata"));

        List<Utente> studenti = classe.getStudenti();
        if (studenti != null) {
            studenti.addAll(studentiIn.stream().map(UtenteDTO::toEntity).toList());
        } else {
            studenti = studentiIn.stream().map(UtenteDTO::toEntity).toList();
        }

        classeRepo.save(classe);
    }

    public List<ClasseDTO> findAll() {
        return classeRepo.findAll().stream().map(ClasseDTO::fromEntity).toList();
    }

    public ClasseDTO findById(Long id) {
        return ClasseDTO.fromEntity(getById(id));
    }

    public Classe getById(Long id) {
        return classeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("classe " + id + " non trovata"));
    }

    public List<ClasseDTO> findByCorsoId(Long corsoId) {
        return classeRepo.findByCorsoId(corsoId).stream().map(ClasseDTO::fromEntity).toList();
    }

    public List<ClasseDTO> findByStudenteId(Long utenteId) {
        return classeRepo.findByStudenteId(utenteId).stream().map(ClasseDTO::fromEntity).toList();
    }

    public void deleteById(Long id) {
        classeRepo.deleteById(id);
    }

}
