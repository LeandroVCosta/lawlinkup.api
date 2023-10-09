package lawlinkup.domain

import lawlinkup.domain.users.Cliente
import lawlinkup.dto.requests.CasoRequest
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "caso")
@Table(name = "caso")
class Caso (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idCaso: Long?,
        val servico:String,
        val especificacao:String,
        val detalhamento:String,
        @ManyToOne
        @JoinColumn(name = "fk_cliente", referencedColumnName = "id_cliente" )
        val cliente: Cliente,
        val dataCriacao:LocalDateTime,
        val ativo:Boolean
        ){
        constructor(caso: CasoRequest, cliente: Cliente) : this(
                caso.idCaso,
                caso.servico,
                caso.especificacao,
                caso.detalhamento,
                cliente,
                LocalDateTime.now(),
                caso.ativo
        )
}