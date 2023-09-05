package lawlinkup.Projeto.lawLinkup.usuario.abstrata

import jakarta.persistence.Entity
import jakarta.persistence.Table
import lawlinkup.Projeto.lawLinkup.usuario.tipo.Tipo
import java.time.LocalDate
import java.time.LocalDateTime
@Entity(name = "cliente")
@Table(name = "usuario")
class ClienteAbstract(
    idUsuario:Long,
    nome:String,
    senha:String,
    email:String,
    contato:String,
    cepString: String,
    cidade:String,
    bairro:String,
    tipoUsuario: Tipo,
    var profissao:String,
    var dataNascimento: LocalDate,
    var estadoCivil:String,
    var sexo:String,
) : Abstract(
    idUsuario,
    nome,
    senha,
    email,
    contato,
    cepString,
    cidade,
    bairro,

){
    override fun postUsuario(): ClienteAbstract {
    return  this
    }

    override fun getUsuario(): List<ClienteAbstract> {
        val listaDeClientes: MutableList<ClienteAbstract> = mutableListOf()
        listaDeClientes.add(this)
        return listaDeClientes
    }

    override fun login(): Abstract {
        return this
    }

    constructor(dados: DadosClienteDto, tipoUsuario: Tipo): this (
        dados.idUsuario,
        dados.nome,
        dados.senha,
        dados.email,
        dados.contato,
        dados.cep,
        dados.cidade,
        dados.bairro,
        tipoUsuario,
        dados.profissao,
        dados.dataNascimento,
        dados.estadoCivil,
        dados.sexo,

    )


}