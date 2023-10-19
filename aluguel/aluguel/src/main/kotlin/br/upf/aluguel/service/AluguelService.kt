import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AluguelService(@Autowired val aluguelRepository: AluguelRepository) {

    fun findAll(): List<Aluguel> = aluguelRepository.findAll()

    fun findById(id: Long): Aluguel? = aluguelRepository.findById(id).orElse(null)

    fun save(aluguel: Aluguel): Aluguel = aluguelRepository.save(aluguel)

    fun deleteById(id: Long) = aluguelRepository.deleteById(id)

    // Adicione outros métodos conforme necessário
}
