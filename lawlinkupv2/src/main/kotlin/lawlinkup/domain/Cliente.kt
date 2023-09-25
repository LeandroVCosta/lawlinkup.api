package lawlinkup.lawlinkupv2.domain

import lawlinkup.domain.Tipo
import java.util.Date
import javax.persistence.*

@Entity(name = "cliente")
@Table(name = "cliente")
class Cliente(
    id:Long,
    email:String,
    nome:String,
    senha:String,
    contato:String,
    cep:String,
    cidade:String,
    bairro:String,
    fotoUrl:String?,
    tipoUsuario:Tipo,
    cpf:String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idCliente:Long,
    val estadoCivil:String,
    val genero:String,
    val dataNascimento:Date,
    val sexo:String,
):Usuario(id, email, nome, senha, contato, cep, cidade, bairro, fotoUrl, tipoUsuario, cpf){

}