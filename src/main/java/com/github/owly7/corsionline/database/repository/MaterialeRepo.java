package com.github.owly7.corsionline.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.lezione.Materiale;
import java.util.List;

@Repository
public interface MaterialeRepo extends JpaRepository<Materiale, Long> {
    @Query("SELECT m FROM Materiale m JOIN m.lezioni l WHERE l.id = :id")
    List<Materiale> findByLezioneId(@Param("id") Long id);
}
