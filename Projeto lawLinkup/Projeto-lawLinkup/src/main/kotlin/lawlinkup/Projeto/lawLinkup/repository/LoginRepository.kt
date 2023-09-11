package lawlinkup.Projeto.lawLinkup.repository

<<<<<<< Updated upstream
import lawlinkup.Projeto.lawLinkup.autenticacao.Login
=======
import lawlinkup.Projeto.lawLinkup.domain.Login
>>>>>>> Stashed changes
import org.springframework.data.jpa.repository.JpaRepository

interface LoginRepository : JpaRepository<Login, Long> {
}