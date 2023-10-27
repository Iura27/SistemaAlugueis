package br.upf.Aluguel.controller

import br.upf.Aluguel.dto.ClienteDTO
import br.upf.Aluguel.dto.ClienteResponseDTO
import br.upf.Aluguel.service.ClienteService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/clientes")
class ClienteController(private val service: ClienteService<Any?>) {

    @GetMapping
    fun listar(): List<ClienteResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ClienteResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastrar(@RequestBody @Valid dto: ClienteDTO, uriBuilder: UriComponentsBuilder): ResponseEntity<ClienteResponseDTO> {
        val clienteResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/clientes/${clienteResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(clienteResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long, @RequestBody @Valid dto: ClienteDTO): ClienteResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}
