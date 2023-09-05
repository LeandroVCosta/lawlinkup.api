package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.autenticacao.Login
import org.springframework.data.jpa.repository.JpaRepository

interface LoginRepository : JpaRepository<Login, Long> {
}