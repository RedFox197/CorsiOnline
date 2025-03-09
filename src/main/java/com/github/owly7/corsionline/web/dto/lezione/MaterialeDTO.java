package com.github.owly7.corsionline.web.dto.lezione;

import com.github.owly7.corsionline.database.entity.lezione.Materiale;

//TODO validare
public record MaterialeDTO(
    Long id,
    String nome,
    String tipo,
    String url
) {

    public static MaterialeDTO fromEntity(Materiale materiale) {
        return new MaterialeDTO(
            materiale.getId(),
            materiale.getNome(),
            materiale.getTipo(),
            materiale.getUrl()
        );
    }

}
