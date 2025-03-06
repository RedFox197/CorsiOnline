package com.github.owly7.fantarobot.database.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.owly7.fantarobot.database.entity.Utente;
import com.github.owly7.fantarobot.database.repository.UtenteRepo;

import jakarta.transaction.Transactional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public Utente save(Utente entity) {
        return utenteRepo.save(entity);
    }

    public void delete(Utente utente) {
        utenteRepo.delete(utente);
    }

    public List<Utente> findAll() {
        return utenteRepo.findAll();
    }

    public Optional<Utente> findById(Long id) {
        return utenteRepo.findById(id);
    }

    public void deleteById(Long id) {
        utenteRepo.deleteById(id);
    }

    @Transactional
    public List<Utente> findAllWithCorso() {
        List<Utente> utenti = utenteRepo.findAll();
        utenti.forEach(t -> {
            Hibernate.initialize(t.getCorsi());
        });
        return utenti;

    }

}
