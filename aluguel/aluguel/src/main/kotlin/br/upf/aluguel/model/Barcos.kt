package br.upf.Aluguel.model

import jakarta.persistence.*
import java.time.LocalDate



@Entity
data class Barcos(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val marca: String?,
    val anoFabr: LocalDate,
    @Enumerated(EnumType.STRING)
    val disponibilidade: Disponibilidade,
    @ManyToOne
    @JoinColumn(name = "tipo_barco_id")
    val tipoBarco: TipoBarco
)

{
    // Construtor padrão (sem argumentos) necessário para o Hibernate
    constructor() : this(null, null, LocalDate.now(), Disponibilidade.DISPONÍVEL, TipoBarco(1,"", ""))
}