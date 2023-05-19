package lawlinkup.Projeto.lawLinkup.cliente.caso

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.cliente.Cliente


@Table(name = "Caso")
@Entity(name = "Caso")
class Caso (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var tipoServico:String,
    var especificacao:String,
    var descricao: String,

    @ManyToOne
    @JoinColumn(name = "fk_cliente", referencedColumnName = "id" )
    var cliente: Cliente
)
{
    constructor(caso: DadosCasoDto, cliente:Cliente):this(
    caso.id,
    caso.tipoServico,
    caso.especificacao,
    caso.descricao,
    cliente
)



}