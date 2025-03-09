package com.github.owly7.corsionline.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Evento;
import java.util.List;

@Repository
public interface EventoRepo extends JpaRepository<Evento, Long> {
    @Query("SELECT e FROM Evento e WHERE e.classe.id = :id")
    List<Evento> findByClasseId(@Param("id") Long id);
}
