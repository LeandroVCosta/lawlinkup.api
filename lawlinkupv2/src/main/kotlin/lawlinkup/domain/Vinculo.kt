package lawlinkup.domain

import Advogado
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "vinculo")
@Table(name = "vinculo")

class Vinculo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idVinculo:Long,

    @ManyToOne
    @JoinColumn(name = "fk_advogado", referencedColumnName = "idUsuario")
    var advogado: Advogado,

    @ManyToOne
    @JoinColumn(name = "fk_caso")

    var caso: Caso,
    var avaliacao: Int,
    var prazoFinal: LocalDate,
    var dataCriacao: LocalDateTime,
    ) {
}