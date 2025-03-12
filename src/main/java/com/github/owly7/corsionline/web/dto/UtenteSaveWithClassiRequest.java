package com.github.owly7.corsionline.web.dto;

import java.util.List;

import com.github.owly7.corsionline.database.entity.Utente;

public record UtenteSaveWithClassiRequest(
    String nome,
    String cognome,
    String email,
    String ruolo,
    List<Long> classiIds
) {

    public static Utente toEntity(UtenteSaveWithClassiRequest dto) {
        if (dto == null) {
            return null;
        }
        Utente utente = new Utente();
        utente.setNome(dto.nome());
        utente.setCognome(dto.cognome());
        utente.setEmail(dto.email());
        utente.setRuolo(Utente.Ruolo.valueOf(dto.ruolo()));
        return utente;
    }

}
