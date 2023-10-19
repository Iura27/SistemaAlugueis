import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alugueis")
class AluguelController(@Autowired val aluguelService: AluguelService) {

        @GetMapping
        fun getAllAlugueis(): ResponseEntity<List<Aluguel>> {
                return ResponseEntity.ok(aluguelService.findAll())
        }

        @PostMapping
        fun createAluguel(@RequestBody aluguel: Aluguel): ResponseEntity<Aluguel> {
                return ResponseEntity.ok(aluguelService.save(aluguel))
        }

        // Adicione outros endpoints conforme necessário
}
