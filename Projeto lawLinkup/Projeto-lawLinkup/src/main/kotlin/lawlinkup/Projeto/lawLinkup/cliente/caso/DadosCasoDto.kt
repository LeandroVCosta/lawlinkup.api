package lawlinkup.Projeto.lawLinkup.cliente.caso

import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotBlank
import lawlinkup.Projeto.lawLinkup.cliente.Cliente

data class DadosCasoDto(
    var id: Long,

    @NotBlank
    var tipoServico: String,

    @NotBlank
    var especificacao: String,

    @NotBlank
    var descricao:String,

    var clienteId: Long,

) {
}