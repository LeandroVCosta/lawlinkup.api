package lawlinkup.Projeto.lawLinkup.cliente

import jakarta.persistence.*

@Table(name = "cliente")
@Entity(name = "Cliente")
class Cliente (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var nome: String,
    var email: String,
    var senha: String,
    var telefone: String,
    var ativo: Boolean?,

)
{
    constructor(cliente: DadosCadastroClienteDto): this(
        cliente.id,
        cliente.nome,
        cliente.email,
        cliente.senha,
        cliente.telefone,
        cliente.ativo
        )


    fun toDTO(): ClienteDto {
        return ClienteDto(
            id = this.id,
            nome = this.nome,
            email = this.email,
            senha = this.senha,
            telefone = this.telefone
        )
    }


    fun exluirUsuario(){
        this.ativo = false
    }

}