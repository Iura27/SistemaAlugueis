package br.upf.Aluguel.converters

import br.upf.Aluguel.dto.TipoBarcoDTO
import br.upf.Aluguel.dto.TipoBarcoResponseDTO
import br.upf.Aluguel.model.TipoBarco
import org.springframework.stereotype.Component


@Component
class TipoBarcoConverter {
    fun toTipoBarco(dto: TipoBarcoDTO): TipoBarco {
        return TipoBarco(
            nome = dto.nome,
            descricao = dto.descricao

            )
    }

    fun toTipoBarcoResponseDTO(tipoBarco: TipoBarco ): TipoBarcoResponseDTO {
        return TipoBarcoResponseDTO(
            id = tipoBarco.id,
            nome = tipoBarco.nome,
            descricao = tipoBarco.descricao
        )
    }
}