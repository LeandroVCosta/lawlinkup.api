package lawlinkup.lawlinkupv2.domain

import javax.persistence.Entity
import javax.persistence.Table

@Entity(name = "advogado")
@Table(name = "advogado")
class Advogado(
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
    val numeroOab:Int,
    val sobre:String,
    val especializacao:String,
    val fotoOab:String?
):Usuario(id, email, nome, senha, contato, cep, cidade, bairro, fotoUrl, tipoUsuario, cpf) {
}