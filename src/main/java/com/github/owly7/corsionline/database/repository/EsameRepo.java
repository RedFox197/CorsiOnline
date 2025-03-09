package com.github.owly7.corsionline.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Esame;
import java.util.List;

@Repository
public interface EsameRepo extends JpaRepository<Esame, Long> {
    @Query("SELECT e FROM Esame e WHERE e.studente.id = :id")
    List<Esame> findByUtenteId(@Param("id") Long id);

    @Query("SELECT e FROM Esame e WHERE e.classe.id = :id")
    List<Esame> findByClasseId(@Param("id") Long id);
}
