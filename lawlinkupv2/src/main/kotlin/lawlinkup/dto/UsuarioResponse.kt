package lawlinkup.dto

import lawlinkup.lawlinkupv2.domain.Usuario

data class UsuarioResponse(
    val nome:String,
    val email:String,
    val tipoUsuario:String
)