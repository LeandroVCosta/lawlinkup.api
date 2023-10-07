package lawlinkup.repository

import lawlinkup.domain.Tipo
import org.springframework.data.jpa.repository.JpaRepository

interface TipoRepository : JpaRepository <Tipo,Long> {
}