package lawlinkup.Projeto.lawLinkup.usuario.abstrata
import jakarta.validation.constraints.NotNull
import org.threeten.bp.LocalDate

data class DadosClienteDto(
    @field:NotNull
    var idUsuario:Long,
    var nome:String,
    var senha:String,
    var email:String,
    var contato:String,
    var cep:String,
    var cidade:String,
    var bairro:String,
    var profissao:String,
    var dataNascimento: LocalDate,
    var estadoCivil:String,
    var sexo:String,
    var tipoUsuarioId:Long
)
