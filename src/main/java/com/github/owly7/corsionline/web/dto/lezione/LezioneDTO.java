package com.github.owly7.corsionline.web.dto.lezione;

import com.github.owly7.corsionline.web.dto.ClasseDTO;

public record LezioneDTO(
    Long id,
    String titolo,
    String descrizione,
    ClasseDTO classe
) {

}
