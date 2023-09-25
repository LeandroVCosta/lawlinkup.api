package lawlinkup.repository

import lawlinkup.lawlinkupv2.domain.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository:JpaRepository<Cliente,Long> {
}