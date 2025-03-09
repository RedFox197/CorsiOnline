package com.github.owly7.corsionline.web.dto;

import com.github.owly7.corsionline.database.entity.Utente.Ruolo;

public record UtenteDTO(
    Long id,
    String nome,
    String cognome,
    String email,
    Ruolo ruolo
) {

}
