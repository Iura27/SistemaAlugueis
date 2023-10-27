package br.upf.Aluguel.controller

import br.upf.Aluguel.dto.TipoBarcoDTO
import br.upf.Aluguel.dto.TipoBarcoResponseDTO
import br.upf.Aluguel.service.TipoBarcoService
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
@RequestMapping("/tiposbarco")
class TipoBarcoController(private val service: TipoBarcoService) {

    @GetMapping
    fun listar( @RequestParam(required = false) nome: String?,
                @PageableDefault(size = 10) paginacao: Pageable
    )
            : Page<TipoBarcoResponseDTO> {
        return service.listar(nome, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TipoBarcoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: TipoBarcoDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<TipoBarcoResponseDTO> {
        val tipoBarcoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/tiposbarco/${tipoBarcoResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(tipoBarcoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: TipoBarcoDTO): TipoBarcoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
