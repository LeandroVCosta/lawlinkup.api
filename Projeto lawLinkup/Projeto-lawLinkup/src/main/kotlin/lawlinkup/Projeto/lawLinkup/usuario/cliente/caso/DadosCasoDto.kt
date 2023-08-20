package lawlinkup.Projeto.lawLinkup.usuario.cliente.caso

import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.NotBlank
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario
import lawlinkup.Projeto.lawLinkup.usuario.tipo.Tipo
import java.time.LocalDateTime

data class DadosCasoDto(
    var idCaso: Long,

    @NotBlank
    var servico: String,

    @NotBlank
    var especificacao: String,

    @NotBlank
    var detalhamento:String,

    var clienteId: Long,



) {
}