package lawlinkup.domain

import javax.persistence.*

@Entity(name = "tipoUsuario")
@Table(name = "tipoUsuario")

class Tipo (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idTipo:Long,
    var nome: String

        ) {
}