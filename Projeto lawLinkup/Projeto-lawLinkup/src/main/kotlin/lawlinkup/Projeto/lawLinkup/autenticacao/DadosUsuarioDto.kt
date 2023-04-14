package lawlinkup.Projeto.lawLinkup.autenticacao

data class DadosUsuarioDto(
    var login:String,
    var senha:String,
    var ativo:Boolean
){}
