import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BarcosService(@Autowired val barcosRepository: BarcosRepository) {

    fun findAll(): List<Barco> = barcosRepository.findAll()

    fun findById(id: Long): Barco? = barcosRepository.findById(id).orElse(null)

    fun save(barco: Barco): Barco = barcosRepository.save(barco)

    fun deleteById(id: Long) = barcosRepository.deleteById(id)

    // Adicione outros métodos conforme necessário
}
