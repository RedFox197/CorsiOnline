package com.github.owly7.corsionline.web.dto;

import com.github.owly7.corsionline.database.entity.Utente;
import com.github.owly7.corsionline.database.entity.Utente.Ruolo;

public record UtenteDTO(
    Long id,
    String nome,
    String cognome,
    String email,
    Ruolo ruolo
) {

    public static UtenteDTO fromEntity(Utente utente) {
        if (utente == null) {
            return null;
        }

        return new UtenteDTO(
            utente.getId(),
            utente.getNome(),
            utente.getCognome(), 
            utente.getEmail(), 
            utente.getRuolo()
        );
    }

    public static Utente toEntity(UtenteDTO dto) {
        if (dto == null) {
            return null;
        }
        
        Utente utente = new Utente();
        utente.setId(dto.id());
        utente.setNome(dto.nome());
        utente.setCognome(dto.cognome());
        utente.setEmail(dto.email());
        utente.setRuolo(dto.ruolo());
        return utente;
    }
}
