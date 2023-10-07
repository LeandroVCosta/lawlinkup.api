package lawlinkup.dto.requests

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class ClienteRequest(
    val idUsuario:Long?,
    val email:String,
    val nome:String,
    val senha:String,
    val contato:String,
    val cep:String,
    val cidade:String,
    val bairro:String,
    val numero:Long,
    val fotoUrl:String?,
    val tipoUsuario: Long,
    val cpf:String,
    val idCliente:Long?,
    val estadoCivil:String,
    val genero:String,
    val profissao:String,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val dataNascimento: LocalDate,
    val sexo:String
)