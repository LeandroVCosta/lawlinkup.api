package lawlinkup.domain

import lawlinkup.domain.users.Advogado
import lawlinkup.domain.users.Usuario
import lawlinkup.dto.requests.MensagemRequest
import lawlinkup.dto.requests.VinculoRequest
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "mensagem")
@Table(name = "mensagem")

class Mensagem (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idMensagem: Long?,
    val vinculo:Vinculo,
    val corpoMensagem:String,
    val horario:LocalDateTime,
    val remetente: Usuario,
    val destinatario: Usuario
) {
    constructor(mensagem: MensagemRequest,vinculo: Vinculo, remetente: Usuario, destinatario: Usuario) : this(
        mensagem.idMensagem,
        vinculo,
        mensagem.corpoMensagem,
        LocalDateTime.now(),
        remetente,
        destinatario
    )
}

