package com.github.owly7.corsionline.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.corsionline.database.entity.Corso;
import com.github.owly7.corsionline.database.repository.CorsoRepo;
import com.github.owly7.corsionline.exception.ResourceNotFoundException;
import com.github.owly7.corsionline.web.dto.CorsoDTO;

@Service
public class CorsoService {
    @Autowired
    private CorsoRepo corsoRepo;

    public void save(Corso entity) {
        corsoRepo.save(entity);
    }

    public List<CorsoDTO> findAll() {
        return corsoRepo.findAll().stream().map(CorsoDTO::fromEntity).toList();
    }

    public CorsoDTO findById(Long id) {
        return corsoRepo.findById(id).map(CorsoDTO::fromEntity).orElseThrow(() -> new ResourceNotFoundException("corso " + id + " non trovato"));
    }

    public void deleteById(Long id) {
        corsoRepo.deleteById(id);
    }

}
