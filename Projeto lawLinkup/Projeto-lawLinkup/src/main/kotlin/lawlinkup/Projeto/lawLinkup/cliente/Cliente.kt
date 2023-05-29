package lawlinkup.Projeto.lawLinkup.cliente

import com.google.api.client.util.DateTime
import jakarta.persistence.*
import org.springframework.cglib.core.Local
import org.springframework.core.StandardReflectionParameterNameDiscoverer
import java.time.LocalDateTime

@Table(name = "cliente")
@Entity(name = "Cliente")
data class Cliente (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idCliente: Long,
    var nome: String = "",
    var email: String = "",
    var senha: String = "",
    var contato: String = "",
    var cep:String = "",
    var cidade:String = "",
    var bairro:String = "",
    var numero:String = "",
    var ultimaSessao: LocalDateTime? = null,


)
{
    constructor(cliente: DadosCadastroClienteDto): this(
        cliente.idCliente,
        cliente.nome,
        cliente.email,
        cliente.senha,
        cliente.contato,
        cliente.cep,
        cliente.cidade,
        cliente.bairro,
        cliente.numero,
        )


    fun toDTO(): ClienteDto {

        return ClienteDto(
            id = this.idCliente,
            nome = this.nome,
            email = this.email,
            senha = this.senha,
            contato = this.contato
        )
    }
    fun pegarDataAtual(){
        ultimaSessao = LocalDateTime.now()
    }


}