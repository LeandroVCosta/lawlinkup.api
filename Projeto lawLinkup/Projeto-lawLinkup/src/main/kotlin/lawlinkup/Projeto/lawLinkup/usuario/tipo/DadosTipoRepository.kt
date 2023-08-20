package lawlinkup.Projeto.lawLinkup.usuario.tipo

import org.springframework.data.jpa.repository.JpaRepository

interface DadosTipoRepository : JpaRepository<Tipo, Long> {
}