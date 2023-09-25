package lawlinkup.lawlinkupv2.domain

import javax.persistence.Entity
import javax.persistence.Table

@Entity(name = "usuario")
@Table(name = "usuario")
abstract class Usuario (
    val id:Long,
    val email:String,
    val nome:String,
    val senha:String,
    val contato:String,
    val cep:String,
    val cidade:String,
    val bairro:String,
    val fotoUrl:String?,
    val tipoUsuario:Long,
    val cpf:String,
) {
}