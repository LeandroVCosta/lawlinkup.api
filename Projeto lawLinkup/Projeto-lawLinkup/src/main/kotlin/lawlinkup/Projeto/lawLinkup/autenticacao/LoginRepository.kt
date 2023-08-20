package lawlinkup.Projeto.lawLinkup.autenticacao

import lawlinkup.Projeto.lawLinkup.usuario.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface LoginRepository : JpaRepository<Login, Long> {
}