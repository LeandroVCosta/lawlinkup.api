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
<<<<<<< Updated upstream:Projeto lawLinkup/Projeto-lawLinkup/src/main/kotlin/lawlinkup/Projeto/lawLinkup/usuario/vinculo/Vinculo.kt
    constructor(vinculo: DadosVinculoDto, advogado: Usuario, caso: Caso, cliente: Usuario): this(
=======
    constructor(vinculo: DadosVinculoDto, advogado: Usuario, caso: Caso): this(
>>>>>>> Stashed changes:Projeto lawLinkup/Projeto-lawLinkup/src/main/kotlin/lawlinkup/Projeto/lawLinkup/domain/Vinculo.kt
        vinculo.idVinculo,
        advogado,
        caso,
        vinculo.avaliacao,
        vinculo.prazoFinal
    )


}