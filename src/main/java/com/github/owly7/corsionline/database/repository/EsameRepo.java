package com.github.owly7.corsionline.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Esame;

@Repository
public interface EsameRepo extends JpaRepository<Esame, Long> {

}
