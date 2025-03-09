package com.github.owly7.corsionline.web.dto.lezione;

import com.github.owly7.corsionline.database.entity.lezione.Lezione;
import com.github.owly7.corsionline.web.dto.ClasseDTO;

public record LezioneDTO(
    Long id,
    String titolo,
    String descrizione,
    ClasseDTO classe
) {
    
    public static LezioneDTO fromEntity(Lezione lezione) {
        return new LezioneDTO(
            lezione.getId(),
            lezione.getTitolo(),
            lezione.getDescrizione(),
            ClasseDTO.fromEntity(lezione.getClasse())
        );
    }

}
