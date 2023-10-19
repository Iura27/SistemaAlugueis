import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/clientes")
class ClienteController(@Autowired val clienteService: ClienteService) {

    @GetMapping
    fun getAllClientes(): ResponseEntity<List<Cliente>> {
        return ResponseEntity.ok(clienteService.findAll())
    }

    @PostMapping
    fun createCliente(@RequestBody cliente: Cliente): ResponseEntity<Cliente> {
        return ResponseEntity.ok(clienteService.save(cliente))
    }

    // Adicione outros endpoints conforme necessário (PUT, DELETE, etc.)
}
