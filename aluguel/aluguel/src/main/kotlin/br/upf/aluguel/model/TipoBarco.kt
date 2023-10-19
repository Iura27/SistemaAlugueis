import javax.persistence.Entity

@Entity
data class TipoBarco(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val codigo: Long? = null,
        val nomeTipo: String,
        val descricao: String
)
