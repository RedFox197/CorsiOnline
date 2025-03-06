package com.github.owly7.fantarobot.database.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.owly7.fantarobot.database.entity.Docente;
import com.github.owly7.fantarobot.database.repository.DocenteRepo;

import jakarta.transaction.Transactional;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepo docenteRepo;

    public Docente save(Docente entity) {
        return docenteRepo.save(entity);
    }

    public void delete(Docente docente) {
        docenteRepo.delete(docente);
    }

    public List<Docente> findAll() {
        return docenteRepo.findAll();
    }

    public Optional<Docente> findById(Long id) {
        return docenteRepo.findById(id);
    }

    public void deleteById(Long id) {
        docenteRepo.deleteById(id);
    }

    @Transactional
    public List<Docente> findAllWithCorso() {
        List<Docente> docenti = docenteRepo.findAll();
        docenti.forEach(t -> {
            Hibernate.initialize(t.getCorsi());
        });
        return docenti;

    }

}
