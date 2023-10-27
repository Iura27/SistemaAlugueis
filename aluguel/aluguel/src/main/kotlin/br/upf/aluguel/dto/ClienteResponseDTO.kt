package br.upf.Aluguel.dto

import br.upf.Aluguel.model.TipoUsuario

data class ClienteResponseDTO( val id: Long? = null,
                               val nome: String,
                               val endereco: String,
                               val telefone: String,
                               val tipousuario: TipoUsuario? = null)

