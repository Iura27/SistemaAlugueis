import java.util.Entity
import javax.persistence.ManyToOne

@Entity
data class Aluguel(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val codigo: Long? = null,
        @ManyToOne @JoinColumn(name = "cod_cliente")
        val cliente: Cliente,
        @ManyToOne @JoinColumn(name = "cod_barco")
        val barco: Barco,
        val dataInicio: Date,
        val dataFim: Date,
        val valor: Double
)
