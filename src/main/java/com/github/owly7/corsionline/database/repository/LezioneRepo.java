package com.github.owly7.corsionline.database.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Lezione;

@Repository
public interface LezioneRepo extends JpaRepository<Lezione, Long> {
    @Query("SELECT l FROM Lezione l WHERE l.classe.id = :id")
    List<Lezione> findByClasseId(@Param("id") Long id);

    @Query("SELECT l FROM Lezione l LEFT JOIN FETCH l.materiali WHERE l.id = :id")
    Optional<Lezione> findByIdWithMateriali(@Param("id") Long id);
}
