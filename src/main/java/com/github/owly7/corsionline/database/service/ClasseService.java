package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Classe;
import com.github.owly7.corsionline.database.repository.ClasseRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.ClasseDTO;

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

    public List<ClasseDTO> findAll() {
        return classeRepo.findAll().stream().map(ClasseDTO::fromEntity).toList();
    }

    public ClasseDTO findById(Long id) {
        return classeRepo.findById(id).map(ClasseDTO::fromEntity)
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
