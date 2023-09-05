package lawlinkup.Projeto.lawLinkup.usuario.advogado.orcamento

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.usuario.vinculo.Vinculo

@Table(name = "orcamento")
@Entity(name = "Orcamento")
data class  Orcamento(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idOrcamento: Long? = null,

    var fkTipoServico:Long,
    @ManyToOne()
    @JoinColumn(name = "fk_vinculo", referencedColumnName = "idVinculo")
    var fkVinculo: Vinculo? = null,
    var valorOrcamento:Double? = null,
    var detalhamento:String? = null,
    var status:Boolean = false,
) {

    constructor(dadosOrcamento: dadosOrcamentoDto, vinculo: Vinculo): this(
        dadosOrcamento.idOrcamento,
        dadosOrcamento.tipoServicoId,
        vinculo,
        dadosOrcamento.valorOrcamento,
        dadosOrcamento.detalhamento
    )

}