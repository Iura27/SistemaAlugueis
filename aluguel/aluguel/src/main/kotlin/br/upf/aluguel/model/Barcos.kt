import javax.persistence.Entity

@Entity
data class Barcos(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val codigo: Long? = null,
        val marca: String,
        val anoFabr: Int,
        val disponibilidade: Boolean,
        @ManyToOne @JoinColumn(name = "cod_tip_barco")
        val tipoBarco: TipoBarco
)
