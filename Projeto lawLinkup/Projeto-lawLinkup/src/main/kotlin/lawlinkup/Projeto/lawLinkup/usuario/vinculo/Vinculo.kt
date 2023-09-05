package lawlinkup.Projeto.lawLinkup.usuario.vinculo

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.usuario.cliente.caso.Caso
import lawlinkup.Projeto.lawLinkup.usuario.Usuario
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

    @ManyToOne
    @JoinColumn(name = "fk_cliente", referencedColumnName = "idUsuario")
    var cliente: Usuario? = null,


    var avaliacao: Int? = null,

    var prazoFinal: LocalDate? = null,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),
) {
    constructor(vinculo: DadosVinculoDto, advogado: Usuario, caso: Caso, cliente: Usuario): this(
        vinculo.idVinculo,
        advogado,
        caso,
        cliente,
        vinculo.avaliacao,
        vinculo.prazoFinal
    )


}