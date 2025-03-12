package com.github.owly7.corsionline.database.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.owly7.corsionline.database.entity.Classe;

@Repository
public interface ClasseRepo extends JpaRepository<Classe, Long> {
    List<Classe> findByNome(String nome);

    List<Classe> findByNomeContaining(String nome);

    @Query("SELECT c FROM Classe c WHERE c.corso.id = :id")
    List<Classe> findByCorsoId(@Param("id") Long id);

    @Query("SELECT c FROM Classe c JOIN c.studenti s WHERE s.id = :id")
    List<Classe> findByStudenteId(@Param("id") Long id);

    @Query("SELECT c FROM Classe c LEFT JOIN FETCH c.studenti WHERE c.id = :id")
    Optional<Classe> findByIdWithStudenti(@Param("id") Long id);

    @Query("SELECT c FROM Classe c LEFT JOIN FETCH c.lezioni LEFT JOIN FETCH c.studenti LEFT JOIN FETCH c.esami WHERE c.id = :id")
    Optional<Classe> findByIdWithAll(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Classe c SET c.corso.id = :corsoId WHERE c.id = :classeId")
    void updateCorsoId(@Param("classeId") Long classeId, @Param("corsoId") Long corsoId);

    @Modifying
    @Query("UPDATE Classe c SET c.docente.id = :docenteId WHERE c.id = :classeId")
    void updateDocenteId(@Param("classeId") Long classeId, @Param("docenteId") Long docenteId);

}
