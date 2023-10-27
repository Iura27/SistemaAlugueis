package br.upf.Aluguel.converters

import br.upf.Aluguel.dto.BarcoDTO
import br.upf.Aluguel.dto.BarcoResponseDTO
import br.upf.Aluguel.model.Barcos
import org.springframework.stereotype.Component


@Component
class BarcoConverter {
    fun toBarco(dto: BarcoDTO): Barcos {
        return Barcos(
            marca = dto.marca,
            anoFabr = dto.anoFabr,
            disponibilidade = dto.disponibilidade,
            tipoBarco = dto.tipoBarco // Você pode adicionar a lógica de associação com tipos de barcos aqui
        )
    }

    fun toBarcoResponseDTO(barco: Barcos): BarcoResponseDTO {
        return BarcoResponseDTO(
            id = barco.id,
            marca = barco.marca,
            anoFabr = barco.anoFabr,
            disponibilidade = barco.disponibilidade,
            tipoBarco = barco.tipoBarco // Você pode adicionar a lógica de associação com tipos de barcos aqui
        )
    }

}