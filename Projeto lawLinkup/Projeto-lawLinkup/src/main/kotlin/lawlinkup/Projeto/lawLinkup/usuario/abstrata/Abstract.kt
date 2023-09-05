package lawlinkup.Projeto.lawLinkup.usuario.abstrata

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.usuario.tipo.Tipo
import java.time.LocalDateTime

@Table(name = "usuario")
@Entity(name = "Abstract")
abstract class Abstract(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idUsuario:Long,
    var nome:String,
    var senha:String,
    var email:String,
    var contato:String,
    var cep:String,
    var cidade:String,
    var bairro:String,
    @ManyToOne
    @JoinColumn(name = "fk_tipo", referencedColumnName = "idTipo" )
    var tipoUsuario: Tipo? = null,
    var ultimaSessao: LocalDateTime? = null,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),

    ) {

    abstract fun postUsuario(): Abstract
    abstract fun getUsuario():List<Abstract>
    abstract fun login(): Abstract


}