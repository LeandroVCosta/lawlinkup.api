package lawlinkup.Projeto.lawLinkup.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import lawlinkup.Projeto.lawLinkup.dtos.DadosTipoDto
import java.time.LocalDate
import java.time.LocalDateTime

@Table(name = "visita")
@Entity(name = "Visita")
class Visita(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idVisita:Long? = null,

    @ManyToOne
    @JoinColumn(name = "fk_advogado", referencedColumnName = "idUsuario")
    var advogado: Usuario? = null,
    var dtVisita: LocalDateTime? =  LocalDateTime.now()

) {}
