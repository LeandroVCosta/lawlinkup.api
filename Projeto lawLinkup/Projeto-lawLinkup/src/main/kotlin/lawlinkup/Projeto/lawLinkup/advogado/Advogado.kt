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
    var idAdvogado:Long,
    var nome:String,
    var email:String,
    var senha:String,
    var cpf:String,
    var contato:String,
    var especializacao:String,
    var numeroOab:String,
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