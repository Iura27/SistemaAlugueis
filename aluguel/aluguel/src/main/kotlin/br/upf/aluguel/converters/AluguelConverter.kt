package br.upf.Aluguel.converters

import br.upf.Aluguel.dto.AluguelDTO
import br.upf.Aluguel.dto.AluguelResponseDTO
import br.upf.Aluguel.model.Aluguel
import org.springframework.stereotype.Component


@Component
class AluguelConverter {
    fun toAluguel(dto: AluguelDTO): Aluguel {

        return Aluguel(
            dataInicio = dto.dataInicio,
            dataFim = dto.dataFim,
            valor = dto.valor,
            cliente = dto.cliente,
            barco = dto.barco
        )
    }

    fun toAluguelResponseDTO(aluguel: Aluguel): AluguelResponseDTO {
        return AluguelResponseDTO(
            id = aluguel.id,
            dataInicio = aluguel.dataInicio,
            dataFim = aluguel.dataFim,
            valor = aluguel.valor,
            cliente = aluguel.cliente,
            barco = aluguel.barco
        )
    }
}