package lawlinkup.domain.users

import lawlinkup.domain.Tipo
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date
import javax.persistence.*

@Entity(name = "usuario")
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val idUsuario:Long?,
    open val email:String,
    open var nome:String,
    open val senha:String,
    open val contato:String,
    open val ultimaSessao:LocalDateTime = LocalDateTime.now(),
    open val cep:String,
    open val cidade:String,
    open val bairro:String,
    open val numero:Long,
    open val dataCriacao:LocalDateTime = LocalDateTime.now(),
    open val fotoUrl:String?,
    @ManyToOne
    @JoinColumn(name = "fk_tipo", referencedColumnName = "idTipo")
    open val tipoUsuario:Tipo,
    open val cpf:String,
) {
}