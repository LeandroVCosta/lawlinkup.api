package lawlinkup.domain.users

import lawlinkup.domain.Tipo
import lawlinkup.dto.requests.ClienteRequest
import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "cliente")
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name="id_cliente", referencedColumnName = "idUsuario")
class Cliente(
    idUsuario:Long?,
    email:String,
    nome:String,
    senha:String,
    contato:String,
    ultimaSessao: LocalDateTime,
    cep:String,
    cidade:String,
    bairro:String,
    numero:Long,
    dataCriacao: LocalDateTime,
    fotoUrl:String?,
    tipoUsuario:Tipo,
    cpf:String,
    val estadoCivil:String,
    val genero:String,
    val profissao:String,
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    val dataNascimento:LocalDate,
): Usuario(idUsuario, email, nome, senha, contato, ultimaSessao, cep, cidade, bairro, numero, dataCriacao, fotoUrl, tipoUsuario, cpf), Serializable {
    constructor(cliente: ClienteRequest, tipoUsuario: Tipo): this (
        cliente.idUsuario,
        cliente.email ,
        cliente.nome,
        cliente.senha,
        cliente.contato ,
        LocalDateTime.now(),
        cliente.cep,
        cliente.cidade,
        cliente.bairro,
        cliente.numero,
        LocalDateTime.now(),
        cliente.fotoUrl,
        tipoUsuario,
        cliente.cpf,

        cliente.estadoCivil,
        cliente.genero,
        cliente.profissao,
        cliente.dataNascimento,
    )
}