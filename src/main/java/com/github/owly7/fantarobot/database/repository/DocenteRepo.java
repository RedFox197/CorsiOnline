package com.github.owly7.fantarobot.database.repository;

import org.springframework.stereotype.Repository;
import com.github.owly7.fantarobot.database.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DocenteRepo extends JpaRepository<Docente, Long> {
}
