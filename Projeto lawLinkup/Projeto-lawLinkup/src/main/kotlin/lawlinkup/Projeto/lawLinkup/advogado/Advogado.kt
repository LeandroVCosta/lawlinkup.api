package lawlinkup.Projeto.lawLinkup.advogado

import jakarta.persistence.*
import lawlinkup.Projeto.lawLinkup.advogado.assinatura.Assinatura
import java.time.LocalDate
import java.time.LocalDateTime
import javax.swing.text.StyledEditorKit.BoldAction

@Table(name = "advogado")
@Entity(name = "Advogado")
data class Advogado(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idAdvogado:Long? = null,
    var nome:String? = null,
    var email:String? = null,
    var senha:String? = null,
    var cpf:String? = null,
    var contato:String? = null,
    var especializacao:String? = null,
    var numeroOab:String? = null,
    var sobre:String? = null,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),
    var statusAssinatura: Boolean = true,
    var ultimaSessao: LocalDateTime? = null,
    ) {

    constructor(advogado: DadosAdvogadosDto): this(
        advogado.idAdvogado,
        advogado.nome,
        advogado.email,
        advogado.senha,
        advogado.cpf,
        advogado.contato,
        advogado.especializacao,
        advogado.numeroOab,
    )



}