package lawlinkup.domain

import lawlinkup.lawlinkupv2.domain.Cliente
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "caso")
@Table(name = "caso")
class Caso (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val idCaso: Long,
        val servico:String,
        val especificacao:String,
        val detalhamento:String,
        @ManyToOne
        @JoinColumn(name = "fk_cliente", referencedColumnName = "idUsuario" )
        val cliente:Cliente,
        val dataCriacao:LocalDateTime,
        val ativo:Boolean
        ) {

}