package lawlinkup.Projeto.lawLinkup.advogado.assinatura

import jakarta.persistence.*
import java.time.LocalDateTime

@Table(name = "Assinatura")
@Entity(name = "Assinatura")
class Assinatura(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int,

    var dataInicio: LocalDateTime = LocalDateTime.now(),

    var dataTermino: LocalDateTime = LocalDateTime.now()


) {


}