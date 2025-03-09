package com.github.owly7.corsionline.web.dto;

import java.time.LocalDateTime;

import com.github.owly7.corsionline.database.entity.Evento;

public record EventoDTO(
    Long id,
    String titolo,
    String descrizione,
    LocalDateTime data,
    ClasseDTO classe
) {

    public static EventoDTO fromEntity(Evento evento) {
        return new EventoDTO(
            evento.getId(),
            evento.getTitolo(), 
            evento.getDescrizione(),
            evento.getData(),
            ClasseDTO.fromEntity(evento.getClasse())
        );
    }

}
