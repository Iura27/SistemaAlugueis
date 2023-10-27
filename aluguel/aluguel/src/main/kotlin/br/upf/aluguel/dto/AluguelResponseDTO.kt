package br.upf.Aluguel.dto

import br.upf.Aluguel.model.Barcos
import br.upf.Aluguel.model.Cliente
import java.time.LocalDate

data class AluguelResponseDTO(
    val id: Long?,
    val dataInicio: LocalDate,
    val dataFim: LocalDate,
    val valor: Double,
    val cliente: Cliente, // DTO do cliente
    val barco: Barcos // DTO do barco
)