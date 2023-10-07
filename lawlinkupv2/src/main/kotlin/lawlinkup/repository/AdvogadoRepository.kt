package lawlinkup.repository

import lawlinkup.domain.users.Advogado
import org.springframework.data.jpa.repository.JpaRepository

interface AdvogadoRepository : JpaRepository <Advogado,Long> {

}