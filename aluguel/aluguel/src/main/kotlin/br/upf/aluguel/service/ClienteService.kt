import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClienteService(@Autowired val clienteRepository: ClienteRepository) {

    fun findAll(): List<Cliente> = clienteRepository.findAll()

    fun findById(id: Long): Cliente? = clienteRepository.findById(id).orElse(null)

    fun save(cliente: Cliente): Cliente = clienteRepository.save(cliente)

    fun deleteById(id: Long) = clienteRepository.deleteById(id)

    // Adicione outros métodos conforme necessário
}
