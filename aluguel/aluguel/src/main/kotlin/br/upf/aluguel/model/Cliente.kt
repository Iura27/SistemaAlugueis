package br.upf.Aluguel.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Cliente(
                    @Id
                    @GeneratedValue(strategy = GenerationType.IDENTITY)
                    val id: Long? = null,
                    val nome: String,
                    val endereco: String,
                    val telefone: String,
                    val tipoUsuario: TipoUsuario = TipoUsuario.CLIENTE  )
{
    constructor() : this(null, "", "", "",TipoUsuario.ADMINISTRADOR)
}