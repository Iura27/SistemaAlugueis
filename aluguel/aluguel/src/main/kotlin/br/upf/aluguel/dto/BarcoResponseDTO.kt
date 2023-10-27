package br.upf.Aluguel.dto

import br.upf.Aluguel.model.Disponibilidade
import br.upf.Aluguel.model.TipoBarco
import java.time.LocalDate

data class BarcoResponseDTO(
    val id: Long?,
    val marca: String?,
    val anoFabr: LocalDate,
    val disponibilidade: Disponibilidade,
    val tipoBarco: TipoBarco
)
