package com.github.owly7.corsionline.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Corso;
import java.util.Optional;

@Repository
public interface CorsoRepo extends JpaRepository<Corso, Long> {
    @Query("SELECT c FROM Corso c LEFT JOIN FETCH c.classi WHERE c.id = :id")
    Optional<Corso> findByIdWithClassi(@Param("id") Long id);
}
