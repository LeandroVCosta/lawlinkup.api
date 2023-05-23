package lawlinkup.Projeto.lawLinkup.cliente.vinculo

import com.google.api.client.util.DateTime
import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.advogado.Advogado
import lawlinkup.Projeto.lawLinkup.cliente.Cliente
import lawlinkup.Projeto.lawLinkup.cliente.caso.Caso
import java.time.LocalDateTime

@Table(name = "vinculo")
@Entity(name = "Vinculo")
class Vinculo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @ManyToOne
    @JoinColumn(name = "fk_advogado")
    var advogado:Advogado,

    @ManyToOne
    @JoinColumn(name = "fk_caso")
    var caso:Caso,

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    var cliente: Cliente,


    var avaliacao: Int?,
    var orcamento:Double?,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),
) {
    constructor(vinculo: DadosVinculoDto, advogado: Advogado, caso: Caso, cliente: Cliente ): this(
        vinculo.id,
        advogado,
        caso,
        cliente,
        vinculo.avaliacao,
        vinculo.orcarmento
    )


}