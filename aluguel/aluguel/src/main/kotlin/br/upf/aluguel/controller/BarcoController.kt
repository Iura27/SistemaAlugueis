package br.upf.Aluguel.controller

import br.upf.Aluguel.dto.BarcoDTO
import br.upf.Aluguel.dto.BarcoResponseDTO
import br.upf.Aluguel.service.BarcoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/barcos")
class BarcoController(private val service: BarcoService) {

    @GetMapping
    fun listar( @RequestParam(required = false) marca: String?,
                @PageableDefault(size = 10) paginacao: Pageable
    )
            : Page<BarcoResponseDTO> {
        return service.listar(marca, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): BarcoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: BarcoDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<BarcoResponseDTO> {
        val barcoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/barcos/${barcoResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(barcoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: BarcoDTO): BarcoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
