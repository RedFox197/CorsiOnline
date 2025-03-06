package com.github.owly7.corsionline.database.repository;

import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Utente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
}
