package lawlinkup.Projeto.lawLinkup.advogado

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import javax.swing.text.StyledEditorKit.BoldAction

@Table(name = "advogado")
@Entity(name = "Advogado")
class Advogado(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long,
    var nome:String,
    var email:String,
    var senha:String,
    var cpf:String,
    var telefone:String,
    var especializacao:String,
    var sobre:String? = null,
    var ativo:Boolean = true,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),
    var statusAssinatura: Boolean = true,
) {

    constructor(advogado: DadosAdvogadosDto): this(
        advogado.id,
        advogado.nome,
        advogado.email,
        advogado.senha,
        advogado.cpf,
        advogado.telefone,
        advogado.especializacao
    )


//    fun exluirAdvogado(){
//        this.ativo = false
//    }
//
//
//    fun ativarAdvogado(){
//        this.ativo = true
//    }


}