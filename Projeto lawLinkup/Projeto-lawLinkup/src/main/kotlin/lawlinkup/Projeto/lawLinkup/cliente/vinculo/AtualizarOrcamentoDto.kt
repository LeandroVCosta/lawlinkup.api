package lawlinkup.Projeto.lawLinkup.cliente.vinculo

import jakarta.validation.constraints.NotBlank

data class AtualizarOrcamentoDto(

    var id:Long,

    @NotBlank
    var orcamemento:Double
){

}
