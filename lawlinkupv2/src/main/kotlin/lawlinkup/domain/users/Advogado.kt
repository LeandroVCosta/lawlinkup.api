package lawlinkup.domain.users

import lawlinkup.domain.Tipo
import lawlinkup.dto.requests.AdvogadoRequest
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "advogado")
@Table(name = "advogado")
@PrimaryKeyJoinColumn(name="id_advogado", referencedColumnName = "idUsuario")
class Advogado(
    idUsuario:Long?,
    email:String,
    nome:String,
    senha:String,
    contato:String,
    ultimaSessao:LocalDateTime,
    cep:String,
    cidade:String,
    bairro:String,
    numero:Long,
    dataCriacao:LocalDateTime,
    fotoUrl:String,
    tipoUsuario:Tipo,
    cpf:String,
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val numeroOab:Int,
    val sobre:String,
    val especializacao:String,
    val fotoOabUrl:String?
): Usuario(idUsuario, email, nome, senha, contato, ultimaSessao,cep, cidade, bairro, numero, dataCriacao, fotoUrl, tipoUsuario, cpf), Serializable {
    constructor(advogado: AdvogadoRequest, tipoUsuario: Tipo): this (
        advogado.idUsuario,
        advogado.email ,
        advogado.nome,
        advogado.senha,
        advogado.contato,
        LocalDateTime.now(),
        advogado.cep,
        advogado.cidade,
        advogado.bairro,
        advogado.numero,
        LocalDateTime.now(),
        advogado.fotoUrl,
        tipoUsuario,
        advogado.cpf,

        advogado.numeroOab,
        advogado.sobre,
        advogado.especializacao,
        advogado.fotoOabUrl
    )
}