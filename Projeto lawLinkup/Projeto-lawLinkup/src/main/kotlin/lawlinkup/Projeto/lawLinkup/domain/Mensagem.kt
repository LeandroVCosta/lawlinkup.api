package lawlinkup.Projeto.lawLinkup.domain

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name ="Mensagem")
@Table(name = "mensagem")
class Mensagem (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idMensagem:Long?,

    @ManyToOne()
    @JoinColumn(name = "fk_vinculo", referencedColumnName = "idVinculo")
    val vinculo:Vinculo,

    @ManyToOne
    @JoinColumn(name = "fk_remetente", referencedColumnName = "idUsuario")
    val remetente:Usuario,

    @ManyToOne
    @JoinColumn(name = "fk_destinatario", referencedColumnName = "idUsuario")
    val destinatario:Usuario,

    val mensagem:String,
    val data:LocalDateTime = LocalDateTime.now()
)
