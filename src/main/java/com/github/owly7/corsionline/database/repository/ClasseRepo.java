package com.github.owly7.corsionline.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Classe;

@Repository
public interface ClasseRepo extends JpaRepository<Classe, Long> {
    @Query("SELECT c FROM Classe c WHERE c.corso.id = :id")
    List<Classe> findByCorsoId(@Param("id") Long id);

    @Query("SELECT c FROM Classe c JOIN c.studenti s WHERE s.id = :id")
    List<Classe> findByStudenteId(@Param("id") Long id);
}
