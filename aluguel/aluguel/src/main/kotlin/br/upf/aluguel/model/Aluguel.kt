package br.upf.Aluguel.model

import com.fasterxml.jackson.annotation.JsonIdentityReference
import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Aluguel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val dataInicio: LocalDate,
    val dataFim: LocalDate,
    val valor: Double,
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    val cliente: Cliente, // Relação com o cliente
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "barco_id") // Substitua "barco_id" pelo nome real da coluna que faz referência ao barco na tabela de Aluguel
    val barco: Barcos

) {
    constructor() : this(null, LocalDate.now(),LocalDate.now(), 100.00, Cliente(), Barcos()) // Inicializa os campos de cliente e barco como nulos
}
