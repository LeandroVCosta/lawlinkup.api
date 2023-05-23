package lawlinkup.Projeto.lawLinkup.advogado

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import lawlinkup.Projeto.lawLinkup.advogado.assinatura.Assinatura
import org.hibernate.validator.constraints.br.CPF

data class DadosAdvogadosDto(
    @NotNull
    var idAdvogado:Long,

    @NotBlank(message = "Campo nome é obrigatório!")
    var nome:String,

    @NotBlank(message = "Campo email é obrigatório!")
    @Email
    var email:String,

    @NotBlank(message = "A senha deve conter no mínimo 5 caracteres e no máximo 15")
    @Size(min = 5, max = 15)
    var senha:String,

    @NotBlank(message = "Coloque um CPF válido!")
    @CPF
    var cpf:String,

    @NotBlank(message = "Coloque um telefone válido!")
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})")
    var contato:String,

    @NotBlank(message = "Coloque uma especialização")
    var especializacao:String,

    @NotBlank(message = "O número da OAB deve contér no maxímo 5 caracteres")
    @Size(min = 6, max = 8)
    var numeroOab: String,




) {
}