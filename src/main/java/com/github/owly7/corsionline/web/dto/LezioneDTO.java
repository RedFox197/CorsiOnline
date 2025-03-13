package com.github.owly7.corsionline.web.dto;

import java.time.LocalDateTime;

import com.github.owly7.corsionline.database.entity.Lezione;

public record LezioneDTO(
    Long id,
    String titolo,
    String descrizione,
    LocalDateTime data,
    ClasseDTO classe
) {
    
    public static LezioneDTO fromEntity(Lezione lezione) {
        return new LezioneDTO(
            lezione.getId(),
            lezione.getTitolo(),
            lezione.getDescrizione(),
            lezione.getData(),
            ClasseDTO.fromEntity(lezione.getClasse())
        );
    }

    public static Lezione toEntity(LezioneDTO dto) {
        if (dto == null) {
            return null;
        }

        Lezione lezione = new Lezione();
        lezione.setId(dto.id());
        lezione.setTitolo(dto.titolo());
        lezione.setDescrizione(dto.descrizione());
        lezione.setData(dto.data());
        lezione.setClasse(ClasseDTO.toEntity(dto.classe()));
        return lezione;
    }


}
