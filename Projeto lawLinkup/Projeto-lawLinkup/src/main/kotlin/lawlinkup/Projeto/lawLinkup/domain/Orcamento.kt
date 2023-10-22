package lawlinkup.Projeto.lawLinkup.domain

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.dtos.DadosOrcamentoDto
import java.time.LocalDate

@Table(name = "orcamento")
@Entity(name = "Orcamento")
data class  Orcamento(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idOrcamento: Long? = null,

    var valorOrcamento:Double,
    var prazoFinal:LocalDate,

    @ManyToOne()
    @JoinColumn(name = "fk_vinculo", referencedColumnName = "idVinculo")
    var fkVinculo: Vinculo? = null,

) {

    constructor(dadosOrcamento: DadosOrcamentoDto, vinculo: Vinculo): this(
        dadosOrcamento.idOrcamento,
        dadosOrcamento.valorOrcamento,
        dadosOrcamento.prazoFinal,
        vinculo,
    )

}