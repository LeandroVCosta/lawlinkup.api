package lawlinkup.Projeto.lawLinkup.usuario.cliente.caso

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.usuario.Usuario
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
    @JoinColumn(name = "fk_cliente", referencedColumnName = "idUsuario" )
    var cliente: Usuario? = null,

    var dataCriacao: LocalDateTime = LocalDateTime.now(),

    var ativo: Boolean = false
)
{
    constructor(caso: DadosCasoDto, cliente:Usuario):this(
    caso.idCaso,
    caso.servico,
    caso.especificacao,
    caso.detalhamento,
    cliente
)



}