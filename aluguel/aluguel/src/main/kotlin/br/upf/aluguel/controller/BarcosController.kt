import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/barcos")
class BarcosController (@Autowired val barcoService: BarcoService) {

    @GetMapping
    fun getAllBarcos(): ResponseEntity<List<Barco>> {
        return ResponseEntity.ok(barcoService.findAll())
    }

    @PostMapping
    fun createBarco(@RequestBody barco: Barco): ResponseEntity<Barco> {
        return ResponseEntity.ok(barcoService.save(barco))
    }

    // Adicione outros endpoints conforme necessário
}
