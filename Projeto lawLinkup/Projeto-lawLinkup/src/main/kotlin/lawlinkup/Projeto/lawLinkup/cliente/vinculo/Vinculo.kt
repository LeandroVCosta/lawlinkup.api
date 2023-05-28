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
    var id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "fk_advogado")
    var advogado:Advogado? = null,

    @ManyToOne
    @JoinColumn(name = "fk_caso")
    var caso:Caso? = null,

    @ManyToOne
    @JoinColumn(name = "fk_cliente")
    var cliente: Cliente? = null,


    var avaliacao: Int? = null,
    var orcamento:Double? = null,
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