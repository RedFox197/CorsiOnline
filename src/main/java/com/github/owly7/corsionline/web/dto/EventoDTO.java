package com.github.owly7.corsionline.web.dto;

import java.time.LocalDateTime;

public record EventoDTO(
    Long id,
    String titolo,
    String descrizione,
    LocalDateTime data,
    ClasseDTO classe
) {

}
