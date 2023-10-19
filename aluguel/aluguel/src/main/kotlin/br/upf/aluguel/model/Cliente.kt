import javax.persistence.Entity

@Entity
data class Cliente (
        @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
        val codigo: Long? = null,
        val nome: String,
        val endereco: String,
        val telefone: String
)
