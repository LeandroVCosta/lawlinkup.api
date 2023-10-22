package lawlinkup.Projeto.lawLinkup.domain

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.dto.DadosRegistroDto
import lawlinkup.Projeto.lawLinkup.enuns.Status
import java.time.LocalDateTime

@Entity(name = "Registro")
@Table(name = "Registro")
class Registro(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idHistorico:Long? = null,

    @ManyToOne
    @JoinColumn(name = "fk_vinculo", referencedColumnName = "idVinculo" )
    var vinculo:Vinculo? = null,


    var status: String? = "",

    var dataAlteracao: LocalDateTime = LocalDateTime.now()



) {
//    constructor() : this(0, Vinculo(), "")

    constructor(dados: DadosRegistroDto, vinculo: Vinculo ):this(
        dados.idHistorico,
        vinculo,
        dados.status,
    )
}


