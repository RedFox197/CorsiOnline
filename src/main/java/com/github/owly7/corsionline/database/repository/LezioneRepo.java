package com.github.owly7.corsionline.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Lezione;

@Repository
public interface LezioneRepo extends JpaRepository<Lezione, Long> {
    // fatti giusto per possibile richiesta, ma non utilizzati
    List<Lezione> findByTitolo(String titolo);
    List<Lezione> findByDescrizione(String descrizione);

    //come descritto prendo tutte le lezioni di una classe così sul fronted le mostro direttamente senza filtrare
    @Query("SELECT l FROM Lezione l WHERE l.classe.id = :id")
    List<Lezione> findByClasseId(@Param("id") Long id);
}
