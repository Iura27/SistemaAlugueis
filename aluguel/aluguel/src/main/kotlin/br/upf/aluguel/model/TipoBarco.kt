package br.upf.Aluguel.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class TipoBarco(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val descricao: String,

)

{
    // Construtor padrão (sem argumentos) necessário para o Hibernate
    constructor() : this(null, "", "")
}