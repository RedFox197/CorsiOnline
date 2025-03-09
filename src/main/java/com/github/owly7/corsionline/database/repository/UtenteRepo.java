package com.github.owly7.corsionline.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Utente;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {
    @Query("SELECT u FROM Utente u JOIN u.classi c WHERE c.id = :id")
    List<Utente> findStudenteByClasseId(@Param("id") Long id);
}
