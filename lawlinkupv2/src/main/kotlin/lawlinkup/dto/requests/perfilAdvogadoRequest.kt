package lawlinkup.dto.requests

import javax.validation.constraints.Max
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class perfilAdvogadoRequest(
    val idAdvogado:Long,
    @field:NotBlank
    @field:NotNull
    @field:Size(min = 10, max = 100)
    val nome:String,

    @field:NotBlank
    @field:NotNull
    @field:Size(min = 5, max = 100)
    val especializacao:String,

    @field:Size(max = 300)
    val sobre:String
)
