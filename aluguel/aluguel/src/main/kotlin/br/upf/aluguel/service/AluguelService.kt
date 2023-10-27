package br.upf.Aluguel.service


import br.upf.Aluguel.converters.AluguelConverter
import br.upf.Aluguel.dto.AluguelDTO
import br.upf.Aluguel.dto.AluguelResponseDTO
import br.upf.Aluguel.repository.AluguelRepository
import br.upf.sistemaeventos.exceptions.NotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDate

private const val ALUGUEL_NOT_FOUND_MESSAGE = "Aluguel não encontrado!"

@Service
class AluguelService(private val repository: AluguelRepository,
                     private val converter: AluguelConverter) {

    fun listar(dataInicio: LocalDate?, paginacao: Pageable): Page<AluguelResponseDTO>  {
        val alugueis = if (dataInicio == null) {
            repository.findAllBydataInicioIsNull(paginacao)
        } else {
            repository.findByDataInicio(dataInicio, paginacao)
        }
        return alugueis.map(converter::toAluguelResponseDTO)
    }

    @GetMapping("/{id}")
    fun buscarPorId(id: Long): AluguelResponseDTO {
        val aluguel = repository.findById(id)
            .orElseThrow { NotFoundException(ALUGUEL_NOT_FOUND_MESSAGE) }
        return converter.toAluguelResponseDTO(aluguel)
    }

    fun cadastrar(dto: AluguelDTO): AluguelResponseDTO {
        return converter.toAluguelResponseDTO(
            repository.save(converter.toAluguel(dto))
        )
    }

    fun atualizar(id: Long, dto: AluguelDTO): AluguelResponseDTO {
        val aluguel = repository.findById(id)
            .orElseThrow { NotFoundException(ALUGUEL_NOT_FOUND_MESSAGE) }
            .copy(
                dataInicio = dto.dataInicio,
                dataFim = dto.dataFim,
                valor = dto.valor,
                cliente = dto.cliente,
                barco = dto.barco
            )
        return converter.toAluguelResponseDTO(repository.save(aluguel))
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}
