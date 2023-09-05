package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.usuario.vinculo.Vinculo
import org.springframework.data.jpa.repository.JpaRepository

interface VinculoRepository : JpaRepository<Vinculo, Long>{
}