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

    public List<EsameDTO> findAll() {
        return esameRepo.findAll().stream().map(EsameDTO::fromEntity).toList();
    }

    public EsameDTO findById(Long id) {
        return esameRepo.findById(id).map(EsameDTO::fromEntity).orElseThrow(() -> new ResourceNotFoundException("Esame " + id + " non trovato"));
    }

    public void deleteById(Long id) {
        esameRepo.deleteById(id);
    }
}
