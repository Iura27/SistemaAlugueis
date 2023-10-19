import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tipos-barco")
class TipoBarcoController(@Autowired val tipoBarcoService: TipoBarcoService) {

    @GetMapping
    fun getAllTiposBarco(): ResponseEntity<List<TipoBarco>> {
        return ResponseEntity.ok(tipoBarcoService.findAll())
    }

    @PostMapping
    fun createTipoBarco(@RequestBody tipoBarco: TipoBarco): ResponseEntity<TipoBarco> {
        return ResponseEntity.ok(tipoBarcoService.save(tipoBarco))
    }

    // Adicione outros endpoints conforme necessário
}
