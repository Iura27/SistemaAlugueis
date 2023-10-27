package br.upf.Aluguel.dto

import br.upf.Aluguel.model.Disponibilidade
import br.upf.Aluguel.model.TipoBarco
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class BarcoDTO(@field:NotNull(message = "Barco deve ter nome de uma marca")
                     val marca: String,
                    @field:NotNull(message = "Barco deve ter um ano de fabricação")
                     val anoFabr: LocalDate,
                    val tipoBarco: TipoBarco,
                    val disponibilidade: Disponibilidade

)
