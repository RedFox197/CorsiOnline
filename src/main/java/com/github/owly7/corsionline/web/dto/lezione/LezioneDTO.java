package com.github.owly7.corsionline.web.dto.lezione;

import java.time.LocalDateTime;

import com.github.owly7.corsionline.database.entity.lezione.Lezione;
import com.github.owly7.corsionline.web.dto.ClasseDTO;

public record LezioneDTO(
    Long id,
    String titolo,
    String descrizione,
    LocalDateTime data,
    ClasseDTO classe
) {
    
    public static LezioneDTO fromEntity(Lezione lezione) {
        return new LezioneDTO(
            lezione.getId(),
            lezione.getTitolo(),
            lezione.getDescrizione(),
            lezione.getData(),
            ClasseDTO.fromEntity(lezione.getClasse())
        );
    }

}
