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

        @ManyToOne()
        @JoinColumn(name = "fk_vinculo", referencedColumnName = "idVinculo")
        var vinculo: Vinculo? = null,
        var valorOrcamento:Double? = null,
        var prazoFinal:LocalDate?
) {

    constructor(dadosOrcamento: DadosOrcamentoDto, vinculo: Vinculo): this(
            dadosOrcamento.idOrcamento,
            vinculo,
            dadosOrcamento.valorOrcamento,
            dadosOrcamento.prazoFinal
    )

}