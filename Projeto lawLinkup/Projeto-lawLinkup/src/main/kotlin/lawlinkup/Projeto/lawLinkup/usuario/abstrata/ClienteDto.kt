package lawlinkup.Projeto.lawLinkup.usuario.abstrata

import jakarta.validation.constraints.NotNull
import org.threeten.bp.LocalDate
import java.time.LocalDateTime

data class ClienteDto (
    var profissao:String,
    var dataNascimento:LocalDate,
    var estadoCivil:String,
    var sexo:String,
    var tipoUsuarioId:Long
)