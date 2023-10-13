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
    var idHistorico:Long,

    @ManyToOne
    @JoinColumn(name = "fk_vinculo", referencedColumnName = "idVinculo" )
    var vinculo:Vinculo,


    var status: String,

    var dataAlteracao: LocalDateTime = LocalDateTime.now()



) {

    constructor(dados: DadosRegistroDto, vinculo: Vinculo ):this(
        dados.idHistorico,
        vinculo,
        dados.status,
    )
}


