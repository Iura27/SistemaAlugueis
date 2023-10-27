package br.upf.Aluguel.controller

import br.upf.Aluguel.dto.AluguelDTO
import br.upf.Aluguel.dto.AluguelResponseDTO
import br.upf.Aluguel.service.AluguelService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.time.LocalDate

@RestController
@RequestMapping("/alugueis")
class AluguelController(private val service: AluguelService) {

    @GetMapping
    fun listar(@RequestParam(required = false) dataInicio: LocalDate?,
               @PageableDefault(size = 10) paginacao: Pageable
    )
            : Page<AluguelResponseDTO> {
        return service.listar(dataInicio, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AluguelResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: AluguelDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<AluguelResponseDTO> {
        val aluguelResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/alugueis/${aluguelResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(aluguelResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: AluguelDTO): AluguelResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
