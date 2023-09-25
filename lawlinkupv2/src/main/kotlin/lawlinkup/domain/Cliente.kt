package lawlinkup.lawlinkupv2.domain

import java.util.Date
import javax.persistence.Entity
import javax.persistence.Table

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
    tipoUsuario:Long,
    cpf:String,
    val estadoCivil:String,
    val genero:String,
    val dataNascimento:Date,
    val sexo:String,
):Usuario(id, email, nome, senha, contato, cep, cidade, bairro, fotoUrl, tipoUsuario, cpf){

}