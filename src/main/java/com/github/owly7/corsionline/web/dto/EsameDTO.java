package com.github.owly7.corsionline.web.dto;

import java.time.LocalDate;

import com.github.owly7.corsionline.database.entity.Esame;

public record EsameDTO(
    Long id,
    String tipo,
    String descrizione,
    float punteggio,
    LocalDate data,
    ClasseDTO classe,
    UtenteDTO studente
) {

    public static EsameDTO fromEntity(Esame esame) {
        return new EsameDTO(
            esame.getId(),
            esame.getTipo(),
            esame.getDescrizione(),
            esame.getPunteggio(),
            esame.getData(),
            ClasseDTO.fromEntity(esame.getClasse()), 
            UtenteDTO.fromEntity(esame.getStudente())
        );
    }

}
