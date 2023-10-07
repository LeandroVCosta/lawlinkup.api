package lawlinkup.repository

import lawlinkup.domain.users.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository:JpaRepository<Cliente,Long> {
}