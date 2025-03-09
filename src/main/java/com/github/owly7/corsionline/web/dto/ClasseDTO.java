package com.github.owly7.corsionline.web.dto;

import java.time.LocalDate;

public record ClasseDTO(
    Long id,
    String nome,
    LocalDate dataInizio,
    LocalDate dataFine,
    CorsoDTO corso,
    UtenteDTO docente
) {

}
