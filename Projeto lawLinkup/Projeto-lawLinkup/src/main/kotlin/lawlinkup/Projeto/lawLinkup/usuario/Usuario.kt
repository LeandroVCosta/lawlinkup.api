package lawlinkup.Projeto.lawLinkup.usuario

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario
import lawlinkup.Projeto.lawLinkup.usuario.tipo.Tipo
import java.time.LocalDateTime

@Entity(name = "Usuario")
@Table(name = "usuario")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idUsuario: Long? = null,
    var nome:String? = null,
    var senha:String? = null,
    var email:String? = null,
    var contato:String? = null,
    var cep:String? = null,
    var cidade:String? = null,
    var bairro:String? = null,
    var numero:String? = null,
    var numeroOab:String? = null,
    var sobre:String? = null,
    var especializacao:String? = null,

    @ManyToOne
    @JoinColumn(name = "fk_tipo", referencedColumnName = "idTipo" )
    var tipoUsuario: Tipo? = null,
    var statusAssinatura:Boolean = true ,
    var ultimaSessao: LocalDateTime? = null,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),


    ) {
   constructor(usuario: UsuarioDto,  tipoUsuario: Tipo): this (
       usuario.idUsuario,
       usuario.nome,
       usuario.senha,
       usuario.email ,
       usuario.contato ,
       usuario.cep,
       usuario.cidade,
       usuario.bairro,
       usuario.numero,
       usuario.numeroOab,
       usuario.sobre,
       usuario.especializacao,
       tipoUsuario
   )
}