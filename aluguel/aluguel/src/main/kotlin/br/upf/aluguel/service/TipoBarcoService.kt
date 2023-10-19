import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TipoBarcoService(@Autowired val tipoBarcoRepository: TipoBarcoRepository) {

    fun findAll(): List<TipoBarco> = tipoBarcoRepository.findAll()

    fun findById(id: Long): TipoBarco? = tipoBarcoRepository.findById(id).orElse(null)

    fun save(tipoBarco: TipoBarco): TipoBarco = tipoBarcoRepository.save(tipoBarco)

    fun deleteById(id: Long) = tipoBarcoRepository.deleteById(id)

    // Adicione outros métodos conforme necessário
}
