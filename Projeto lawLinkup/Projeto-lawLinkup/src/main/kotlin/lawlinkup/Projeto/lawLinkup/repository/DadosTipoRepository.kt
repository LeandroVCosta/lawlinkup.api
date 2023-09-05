package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.usuario.tipo.Tipo
import org.springframework.data.jpa.repository.JpaRepository

interface DadosTipoRepository : JpaRepository<Tipo, Long> {
}