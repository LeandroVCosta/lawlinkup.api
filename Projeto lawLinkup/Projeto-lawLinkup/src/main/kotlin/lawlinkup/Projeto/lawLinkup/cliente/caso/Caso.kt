package lawlinkup.Projeto.lawLinkup.cliente.caso

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.cliente.Cliente
import java.time.LocalDateTime


@Table(name = "Caso")
@Entity(name = "Caso")
class Caso (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idCaso: Long? = null,
    var servico:String? = null,
    var especificacao:String? = null,
    var detalhamento: String? = null,

    @ManyToOne
    @JoinColumn(name = "fk_cliente", referencedColumnName = "idCliente" )
    var cliente: Cliente? = null,

    var dataCriacao: LocalDateTime = LocalDateTime.now(),

    var ativo: Boolean = false
)
{
    constructor(caso: DadosCasoDto, cliente:Cliente):this(
    caso.idCaso,
    caso.servico,
    caso.especificacao,
    caso.detalhamento,
    cliente
)



}