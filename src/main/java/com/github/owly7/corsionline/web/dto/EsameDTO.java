package com.github.owly7.corsionline.web.dto;

import java.time.LocalDate;

public record EsameDTO(
    Long id,
    String tipo,
    String descrizione,
    float punteggio,
    LocalDate data,
    ClasseDTO classe,
    UtenteDTO studente
) {

}
