package br.upf.Aluguel.service

import br.upf.Aluguel.converters.ClienteConverter
import br.upf.Aluguel.dto.ClienteDTO
import br.upf.Aluguel.dto.ClienteResponseDTO
import br.upf.Aluguel.repository.ClienteRepository
import br.upf.sistemaeventos.exceptions.NotFoundException
import org.springframework.stereotype.Service

private const val CLIENTE_NOT_FOUND_MESSAGE = "Cliente não encontrado!"

@Service
class ClienteService<Pageable>(private val repository: ClienteRepository,
                               private val converter: ClienteConverter) {

    fun listar(): List<ClienteResponseDTO> {
        return repository.findAll()
            .map(converter::toClienteResponseDTO)
    }

    fun buscarPorId(id: Long): ClienteResponseDTO {
        val cliente = repository.findById(id)
            .orElseThrow { NotFoundException(CLIENTE_NOT_FOUND_MESSAGE) }
        return converter.toClienteResponseDTO(cliente)
    }

    fun cadastrar(dto: ClienteDTO): ClienteResponseDTO {
        return converter.toClienteResponseDTO(
            repository.save(converter.toCliente(dto))
        )
    }

    fun atualizar(id: Long, dto: ClienteDTO): ClienteResponseDTO {
        val cliente = repository.findById(id)
            .orElseThrow { NotFoundException(CLIENTE_NOT_FOUND_MESSAGE) }
            .copy(
                nome = dto.nome,
                telefone = dto.telefone,
                endereco = dto.endereco,
                tipoUsuario = dto.tipousuario
            )
        return converter.toClienteResponseDTO(repository.save(cliente))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}
