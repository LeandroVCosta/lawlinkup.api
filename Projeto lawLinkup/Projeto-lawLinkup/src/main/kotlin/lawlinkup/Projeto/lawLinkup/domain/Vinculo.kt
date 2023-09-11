package lawlinkup.Projeto.lawLinkup.domain

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.dtos.DadosVinculoDto
import java.time.LocalDate
import java.time.LocalDateTime

@Table(name = "vinculo")
@Entity(name = "Vinculo")
class Vinculo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idVinculo: Long? = null,

    @ManyToOne
    @JoinColumn(name = "fk_advogado", referencedColumnName = "idUsuario")
    var advogado: Usuario? = null,

    @ManyToOne
    @JoinColumn(name = "fk_caso")
    var caso: Caso? = null,
    var avaliacao: Int? = null,
    var prazoFinal: LocalDate? = null,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),
) {
    constructor(vinculo: DadosVinculoDto, advogado: Usuario, caso: Caso): this(
        vinculo.idVinculo,
        advogado,
        caso,
        vinculo.avaliacao,
        vinculo.prazoFinal
    )


}