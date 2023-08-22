package testechat.testechat.Chat

data class MensagemDTO
    (var idMensagem:Long,
     var mensagem:String,
     var remetente: Long,
     var destinatario: Long ){
}