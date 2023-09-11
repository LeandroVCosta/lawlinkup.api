package lawlinkup.Projeto.lawLinkup.domain

import jakarta.persistence.*
<<<<<<< Updated upstream:Projeto lawLinkup/Projeto-lawLinkup/src/main/kotlin/lawlinkup/Projeto/lawLinkup/usuario/tipo/Tipo.kt
=======
import lawlinkup.Projeto.lawLinkup.dtos.DadosTipoDto
>>>>>>> Stashed changes:Projeto lawLinkup/Projeto-lawLinkup/src/main/kotlin/lawlinkup/Projeto/lawLinkup/domain/Tipo.kt

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
