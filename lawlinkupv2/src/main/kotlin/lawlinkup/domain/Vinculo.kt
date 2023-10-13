package lawlinkup.domain

import lawlinkup.domain.users.Advogado
import lawlinkup.dto.requests.VinculoRequest
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "vinculo")
@Table(name = "vinculo")

class Vinculo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idVinculo:Long?,

    @ManyToOne
    @JoinColumn(name = "fk_advogado", referencedColumnName = "id_advogado")
    var advogado: Advogado,

    @ManyToOne
    @JoinColumn(name = "fk_caso", referencedColumnName = "idCaso")
    var caso: Caso,

    var avaliacao: Int,

    var prazoFinal: LocalDate,

    var dataCriacao: LocalDateTime,
    ) {
    constructor(vinculo: VinculoRequest, advogado: Advogado, caso:Caso) : this(
        vinculo.idVinculo,
        advogado,
        caso,
        vinculo.avaliacao,
        vinculo.prazoFinal,
        LocalDateTime.now()
    )
}