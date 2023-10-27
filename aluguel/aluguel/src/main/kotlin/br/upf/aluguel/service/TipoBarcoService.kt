package br.upf.Aluguel.service

import br.upf.Aluguel.converters.TipoBarcoConverter
import br.upf.Aluguel.dto.TipoBarcoDTO
import br.upf.Aluguel.dto.TipoBarcoResponseDTO
import br.upf.Aluguel.repository.TipoBarcoRepository
import br.upf.sistemaeventos.exceptions.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val TIPOBARCO_NOT_FOUND_MESSAGE = "Tipo de Barco não encontrado!"

@Service
class TipoBarcoService(private val repository: TipoBarcoRepository,
                                 private val converter: TipoBarcoConverter) {

    fun listar(
        nome: String?,
        paginacao: Pageable
    ): Page<TipoBarcoResponseDTO> {
        val tiposBarco = if (nome == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nome, paginacao)
        }
        return tiposBarco.map(converter::toTipoBarcoResponseDTO)
    }

    fun buscarPorId(id: Long): TipoBarcoResponseDTO {
        val tipoBarco = repository.findById(id)
            .orElseThrow {
                val TIPO_BARCO_NOT_FOUND_MESSAGE = "Tipo não encontrado"
                NotFoundException(TIPO_BARCO_NOT_FOUND_MESSAGE)
            }
        return converter.toTipoBarcoResponseDTO(tipoBarco)
    }

    fun cadastrar(dto: TipoBarcoDTO): TipoBarcoResponseDTO {
        return converter.toTipoBarcoResponseDTO(
            repository.save(converter.toTipoBarco(dto))
        )
    }

    fun atualizar(id: Long, dto: TipoBarcoDTO): TipoBarcoResponseDTO {
        val tipoBarco = repository.findById(id)
            .orElseThrow {
                val TIPO_BARCO_NOT_FOUND_MESSAGE = "Tipo não encontrado"
                NotFoundException(TIPO_BARCO_NOT_FOUND_MESSAGE)
            }
            .copy(
                nome = dto.nome,
                descricao = dto.descricao
            )
        return converter.toTipoBarcoResponseDTO(repository.save(tipoBarco))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}
