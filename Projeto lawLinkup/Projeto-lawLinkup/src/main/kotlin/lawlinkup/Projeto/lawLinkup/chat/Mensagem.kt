package lawlinkup.Projeto.lawLinkup.chat

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Mensagem (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long,
    var fkCaso:Long,
    var mensagem:String,
    var dataMensagem:LocalDateTime = LocalDateTime.now(),
    var tipoUsuario:String
        )