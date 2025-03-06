package com.github.owly7.fantarobot.database.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.owly7.fantarobot.database.entity.Studente;

@Repository
public interface StudenteRepo extends JpaRepository<Studente, Long> {
    List<Studente> findByCorsi_Id(Long corsoId);
}



