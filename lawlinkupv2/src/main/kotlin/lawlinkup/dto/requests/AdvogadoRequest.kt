package lawlinkup.dto.requests

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


data class AdvogadoRequest(
    val idUsuario:Long?,

    @field:Email
    val email:String,

    @field:NotBlank
    @field:NotNull
    val nome:String,

    @field:NotBlank
    @field:NotNull
    val senha:String,

    @field:NotBlank
    @field:NotNull
    val contato:String,

    @field:NotBlank
    @field:NotNull
    val cep:String,

    @field:NotBlank
    @field:NotNull
    val cidade:String,

    @field:NotBlank
    @field:NotNull
    val bairro:String,

    val numero:Long,

    val fotoUrl:String,
    val cpf:String,
    val numeroOab:Int,
    val sobre:String,
    val especializacao:String,
    val fotoOabUrl:String?
)
