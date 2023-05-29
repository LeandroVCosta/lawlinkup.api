package lawlinkup.Projeto.lawLinkup.advogado

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import lawlinkup.Projeto.lawLinkup.advogado.assinatura.Assinatura
import org.hibernate.validator.constraints.br.CPF

data class DadosAdvogadosDto(

    @field:NotNull
    var idAdvogado:Long,

    @field:NotBlank(message = "Campo nome é obrigatório!")
    @field:Pattern(regexp = "^[a-zA-Zàèìòùáéíóúâêîôûãõ\b]+$")
    var nome:String,

    @field:NotBlank(message = "Campo email é obrigatório!")
    @field:Email
    var email:String,

    @field:NotBlank(message = "A senha deve conter no mínimo 5 caracteres e no máximo 15")
    @field:Size(min = 5, max = 15)
    var senha:String,

    @field:NotBlank(message = "Coloque um CPF válido!")
    @field:CPF
    var cpf:String,

    @field:NotBlank(message = "Coloque um telefone válido!")
    @field:Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})")
    var contato:String,

    @field:NotBlank(message = "Coloque uma especialização")
    var especializacao:String,

    @field:NotBlank(message = "O número da OAB deve contér no maxímo 5 caracteres")
    @field:Size(min = 6, max = 8)
    var numeroOab: String,

) {
}