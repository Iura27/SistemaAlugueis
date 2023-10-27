package br.upf.Aluguel.converters

import br.upf.Aluguel.dto.ClienteDTO
import br.upf.Aluguel.dto.ClienteResponseDTO
import br.upf.Aluguel.model.Cliente
import org.springframework.stereotype.Component


@Component
class ClienteConverter {
    fun toCliente(dto: ClienteDTO): Cliente {
        return Cliente(
            nome = dto.nome,
            telefone = dto.telefone,
            endereco = dto.endereco,
            tipoUsuario = dto.tipousuario

        )
    }

    fun toClienteResponseDTO(cliente: Cliente ): ClienteResponseDTO {
        return ClienteResponseDTO(
            id = cliente.id,
            nome = cliente.nome,
            telefone = cliente.telefone,
            endereco = cliente.endereco,
            tipousuario = cliente.tipoUsuario
        )
    }
}