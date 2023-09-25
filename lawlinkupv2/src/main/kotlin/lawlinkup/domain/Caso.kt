package lawlinkup.domain

import lawlinkup.lawlinkupv2.domain.Cliente
import java.time.LocalDateTime

class Caso (
        val idCaso: Long,
        val servico:String,
        val especificacao:String,
        val detalhamento:String,
        val cliente:Cliente,
        val dataCriacao:LocalDateTime,
        val ativo:Boolean
        ) {

}