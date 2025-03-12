package com.github.owly7.corsionline.web.dto;

import java.time.LocalDate;

import com.github.owly7.corsionline.database.entity.Esame;

public record EsameDTO(
    Long id,
    String tipo,
    String descrizione,
    float punteggio,
    LocalDate data,
    ClasseDTO classe,
    UtenteDTO studente
) {

    public static EsameDTO fromEntity(Esame esame) {
        return new EsameDTO(
            esame.getId(),
            esame.getTipo(),
            esame.getDescrizione(),
            esame.getPunteggio(),
            esame.getData(),
            ClasseDTO.fromEntity(esame.getClasse()), 
            UtenteDTO.fromEntity(esame.getStudente())
        );
    }

    public static Esame toEntity(EsameDTO dto) {
        if (dto == null) {
            return null;
        }
        Esame esame = new Esame();
        esame.setId(dto.id());
        esame.setTipo(dto.tipo());
        esame.setDescrizione(dto.descrizione());
        esame.setPunteggio(dto.punteggio());
        esame.setData(dto.data());
        esame.setClasse(ClasseDTO.toEntity(dto.classe()));
        esame.setStudente(UtenteDTO.toEntity(dto.studente()));
        return esame;
    }

}
