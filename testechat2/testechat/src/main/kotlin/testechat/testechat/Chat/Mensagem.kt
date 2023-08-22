package testechat.testechat.Chat

import javax.persistence.*

@Table(name = "mensagem")
@Entity(name = "Mensagem")
class Mensagem (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idMensagem:Long,
    val mensagem:String,

    @ManyToOne()
    @JoinColumn(name = "fk_remetente", referencedColumnName = "idUsuario", updatable = false)
    val remetente: Usuario,

    @ManyToOne()
    @JoinColumn(name = "fk_destinatario", referencedColumnName = "idUsuario",  updatable = false)
    val destinatario: Usuario

    ) {
    constructor( dados:MensagemDTO, remetente: Usuario, destinatario: Usuario) : this (
                dados.idMensagem, dados.mensagem, remetente, destinatario
            )
}