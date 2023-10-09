package lawlinkup.repository

import lawlinkup.domain.Vinculo
import org.springframework.data.jpa.repository.JpaRepository

interface VinculoRepository:JpaRepository<Vinculo,Long> {
}