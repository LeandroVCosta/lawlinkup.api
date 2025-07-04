package lawlinkup.Projeto.lawLinkup.usuario.tipo

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario

@Entity(name = "Tipo")
@Table(name = "tipoUsuario")
class Tipo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idTipo:Long? = null,
    var nome: String? = null

) {
    constructor(dadosTipo: DadosTipoDto): this(
        dadosTipo.idTipo,
    )
}
