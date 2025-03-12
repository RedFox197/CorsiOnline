package com.github.owly7.corsionline.web.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.github.owly7.corsionline.database.entity.Lezione;

public record LezioneDTO(
    Long id,
    String titolo,
    String descrizione,
    LocalDateTime data,
    List<String> materiali,
    ClasseDTO classe
) {
    
    public static LezioneDTO fromEntity(Lezione lezione) {
        return new LezioneDTO(
            lezione.getId(),
            lezione.getTitolo(),
            lezione.getDescrizione(),
            lezione.getData(),
            lezione.getMateriali(),
            ClasseDTO.fromEntity(lezione.getClasse())
        );
    }

}
