package lawlinkup.Projeto.lawLinkup.cliente

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull


data class DadosCadastroCliente (
    @NotNull var id:Long,
    @NotBlank(message = "Campo telefone é obrigatório!")
    var nome:String,
    @NotBlank(message = "Campo telefone é obrigatório!")
    var email: String,
    @NotBlank(message = "Campo telefone é obrigatório!")
    var senha: String,
    @NotBlank(message = "Campo telefone é obrigatório!")
    var telefone: String,

    var ativo:Boolean
) {

}