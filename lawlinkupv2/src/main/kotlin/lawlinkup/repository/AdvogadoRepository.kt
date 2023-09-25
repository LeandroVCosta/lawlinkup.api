package lawlinkup.repository

import lawlinkup.lawlinkupv2.domain.Advogado
import org.springframework.data.jpa.repository.JpaRepository

interface AdvogadoRepository : JpaRepository <Advogado,Long> {

}