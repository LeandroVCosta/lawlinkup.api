package lawlinkup.lawlinkupv2.domain

import lawlinkup.domain.Tipo
import javax.persistence.*

@Entity(name = "usuario")
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long,
    val email:String,
    val nome:String,
    val senha:String,
    val contato:String,
    val cep:String,
    val cidade:String,
    val bairro:String,
    val fotoUrl:String?,
    val tipoUsuario:Tipo,
    val cpf:String,
) {
}