package com.github.owly7.corsionline.web.dto.lezione;

import com.github.owly7.corsionline.database.entity.lezione.Materiale;

//TODO validare
public record MaterialeDTO(
    Long id,
    String nome,
    String tipo,
    String url
) {

    public static MaterialeDTO fromEntity(Materiale materiale) {
        return new MaterialeDTO(
            materiale.getId(),
            materiale.getNome(),
            materiale.getTipo(),
            materiale.getUrl()
        );
    }

    public static Materiale toEntity(MaterialeDTO materialeDTO) {
        Materiale materiale = new Materiale();
        materiale.setId(materialeDTO.id());
        materiale.setNome(materialeDTO.nome());
        materiale.setTipo(materialeDTO.tipo());
        materiale.setUrl(materialeDTO.url());
        return materiale;
    }

}
