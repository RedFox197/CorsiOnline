package com.github.owly7.corsionline.web.dto;

import com.github.owly7.corsionline.database.entity.Corso;

public record CorsoDTO(
    Long id,
    String titolo,
    String descrizione
) {

    public static CorsoDTO fromEntity(Corso corso) {
        if (corso == null) {
            return null;
        }
        
        return new CorsoDTO(
            corso.getId(),
            corso.getTitolo(),
            corso.getDescrizione()
        );
    }

}
