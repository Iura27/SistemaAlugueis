package br.upf.Aluguel.service

import br.upf.Aluguel.converters.BarcoConverter
import br.upf.Aluguel.dto.BarcoDTO
import br.upf.Aluguel.dto.BarcoResponseDTO
import br.upf.Aluguel.repository.BarcoRepository
import br.upf.sistemaeventos.exceptions.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


private const val BARCO_NOT_FOUND_MESSAGE = "Barco não encontrado!"

@Service
class BarcoService(private val repository: BarcoRepository, private val converter: BarcoConverter) {

    fun listar(marca: String?,
               paginacao: Pageable): Page<BarcoResponseDTO> {
               val barcos = if (marca == null){
                   repository.findAll(paginacao)
               } else {
                   repository.findByMarca(marca, paginacao)
               }
                return barcos
                    .map(converter::toBarcoResponseDTO)
    }

    fun buscarPorId(id: Long): BarcoResponseDTO {
        val barco = repository.findById(id)
            .orElseThrow {NotFoundException(BARCO_NOT_FOUND_MESSAGE)}
        return converter.toBarcoResponseDTO(barco)
    }

    fun cadastrar(dto: BarcoDTO): BarcoResponseDTO {
        return converter.toBarcoResponseDTO(
        repository.save(converter.toBarco(dto))
        )
    }

    fun atualizar(id: Long, dto: BarcoDTO): BarcoResponseDTO {
        val barco = repository.findById(id)
            .orElseThrow { NotFoundException(BARCO_NOT_FOUND_MESSAGE) }
            .copy(
                tipoBarco = dto.tipoBarco,
                marca = dto.marca,
                anoFabr = dto.anoFabr,
                disponibilidade = dto.disponibilidade
            )
        return converter.toBarcoResponseDTO(repository.save(barco))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}
