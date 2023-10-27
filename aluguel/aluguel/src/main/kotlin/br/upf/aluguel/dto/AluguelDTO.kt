package br.upf.Aluguel.dto
import br.upf.Aluguel.model.Barcos
import br.upf.Aluguel.model.Cliente
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class AluguelDTO(@field:NotNull(message = "Aluguel sempre deve ter uma data de início")
                       val dataInicio: LocalDate,
                      @field:NotNull(message = "Aluguel sempre deve ter uma data final")
                       val dataFim: LocalDate,
                      @field:NotNull(message = "Aluguel sempre deve ter um valor")
                       val valor: Double,
                      val cliente: Cliente, // DTO do cliente
                      val barco: Barcos // DTO do barcos
)
