package com.github.owly7.fantarobot.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.owly7.fantarobot.database.entity.Esame;

@Repository
public interface EsameRepo extends JpaRepository<Esame, Long> {
    List<Esame> findByStudenti_Id(Long studenteId);
}
