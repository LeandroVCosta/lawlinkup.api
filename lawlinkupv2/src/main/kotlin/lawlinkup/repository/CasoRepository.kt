package lawlinkup.repository

import lawlinkup.domain.Caso
import org.springframework.data.jpa.repository.JpaRepository

interface CasoRepository : JpaRepository <Caso,Long> {
}