package lawlinkup.lawlinkupv2.domain

import lawlinkup.domain.Tipo
import javax.persistence.*

@Entity(name = "advogado")
@Table(name = "advogado")
@PrimaryKeyJoinColumn(name="id")
class Advogado(
    id:Long,
    email:String,
    nome:String,
    senha:String,
    contato:String,
    cep:String,
    cidade:String,
    bairro:String,
    fotoUrl:String,
    tipoUsuario:Tipo,
    cpf:String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAdvogado:Long,
    val numeroOab:Int,
    val sobre:String,
    val especializacao:String,
    val fotoOab:String?
):Usuario(id, email, nome, senha, contato, cep, cidade, bairro, fotoUrl, tipoUsuario, cpf) {
}