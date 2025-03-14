package com.github.owly7.corsionline.web.dto;

import java.time.LocalDate;

import com.github.owly7.corsionline.database.entity.Classe;

public record ClasseDTO(
    Long id,
    String nome,
    LocalDate dataInizio,
    LocalDate dataFine,
    CorsoDTO corso,
    UtenteDTO docente
) {

    public static ClasseDTO fromEntity(Classe classe) {
        if (classe == null) {
            return null;
        }
        
        return new ClasseDTO(
            classe.getId(),
            classe.getNome(),
            classe.getDataInizio(),
            classe.getDataFine(),
            CorsoDTO.fromEntity(classe.getCorso()),
            UtenteDTO.fromEntity(classe.getDocente())
        );
    }

    public static Classe toEntity(ClasseDTO dto) {
        if (dto == null) {
            return null;
        }

        Classe classe = new Classe();
        classe.setId(dto.id());
        classe.setNome(dto.nome());
        classe.setDataInizio(dto.dataInizio());
        classe.setDataFine(dto.dataFine());
        classe.setCorso(CorsoDTO.toEntity(dto.corso()));
        classe.setDocente(UtenteDTO.toEntity(dto.docente()));
        return classe;
    }

}
