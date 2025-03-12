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

    public static Corso toEntity(CorsoDTO corsoDTO) {
        if (corsoDTO == null) {
            return null;
        }

        Corso corso = new Corso();
        corso.setId(corsoDTO.id());
        corso.setTitolo(corsoDTO.titolo());
        corso.setDescrizione(corsoDTO.descrizione());

        return corso;
    }

}
