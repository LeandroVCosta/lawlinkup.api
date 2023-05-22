package lawlinkup.Projeto.lawLinkup.cliente.vinculo

import com.google.api.client.util.DateTime
import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.advogado.Advogado
import lawlinkup.Projeto.lawLinkup.cliente.caso.Caso
import java.time.LocalDateTime

@Table(name = "vinculo")
@Entity(name = "Vinculo")
class Vinculo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var dataCriacao: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "fk_advogado")
    var advogado:Advogado,

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    var caso:Caso,
    var avaliacao: Int?,
    var orcamento:String?
) {
//    constructor(vinculo: DadosVinculoDto, advogado: Advogado, caso: Caso ): this(
//        vinculo.id,
//        vinculo.dataCriacao,
//        advogado,
//        caso
//    )


}