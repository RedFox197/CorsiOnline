package com.github.owly7.fantarobot.database.service;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.fantarobot.database.entity.Studente;
import com.github.owly7.fantarobot.database.repository.StudenteRepo;

import jakarta.transaction.Transactional;

@Service
public class StudenteService {
    // visualizzo tutti gli studenti
    @Autowired
    private StudenteRepo studenteRepo;

    public void deleteById(Long id) {
        studenteRepo.deleteById(id);
    }

    public List<Studente> findAll() {

        return studenteRepo.findAll();
    }

    public Studente save(Studente entity) {
        return studenteRepo.save(entity);
    }

    // cerchiamo gli studenti per i vari corsi
    @Transactional
    public List<Studente> findAllByCorso(Long corsoId) {
        return studenteRepo.findByCorsi_Id(corsoId);
}

    // cerchiamo i vari studenti tramite id
    @Transactional
    public Studente findById(Long id) {
    Studente studente = studenteRepo.findById(id).orElse(null);
    if (studente != null) {
        Hibernate.initialize(studente.getClasse());
        Hibernate.initialize(studente.getCorsi());
    }
    return studente;
}

    
}