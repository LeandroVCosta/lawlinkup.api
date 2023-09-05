package lawlinkup.Projeto.lawLinkup.usuario.abstrata

import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioAbsRepository : JpaRepository<ClienteAbstract, Long> {
}