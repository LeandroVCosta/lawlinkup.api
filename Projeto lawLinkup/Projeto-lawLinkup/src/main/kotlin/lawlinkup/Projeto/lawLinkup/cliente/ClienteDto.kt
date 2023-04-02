package lawlinkup.Projeto.lawLinkup.cliente

data class ClienteDto(
    var id:Long,
    var nome: String,
    var email:String,
    var senha:String,
    var telefone:String
) {
}