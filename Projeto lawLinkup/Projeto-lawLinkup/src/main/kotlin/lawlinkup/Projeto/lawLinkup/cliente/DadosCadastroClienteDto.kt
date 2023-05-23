package lawlinkup.Projeto.lawLinkup.cliente

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import java.time.LocalDateTime


data class DadosCadastroClienteDto (
    @NotNull
    var idCliente:Long,

    @NotBlank(message = "Campo nome é obrigatório!")
    var nome:String,

    @NotBlank(message = "Campo email é obrigatório!")
    @Email
    var email: String,

    @NotBlank(message = "A senha deve conter no mínimo 5 caracteres e no máximo 15!")
    var senha: String,

    @NotBlank(message = "Coloque um telefone válido!")
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})")
    var contato: String,

    @NotBlank
    var cep:String,

    @NotBlank
    var cidade:String,

    @NotBlank
    var bairro:String,

    var numero:String,

    ) {

}