package lawlinkup.dto.requests

data class AdvogadoRequest(
    val idUsuario:Long?,
    val email:String,
    val nome:String,
    val senha:String,
    val contato:String,
    val cep:String,
    val cidade:String,
    val bairro:String,
    val numero:Long,
    val fotoUrl:String,
    val tipoUsuario: Long,
    val cpf:String,
    val idAdvogado:Long?,
    val numeroOab:Int,
    val sobre:String,
    val especializacao:String,
    val fotoOabUrl:String?
)
