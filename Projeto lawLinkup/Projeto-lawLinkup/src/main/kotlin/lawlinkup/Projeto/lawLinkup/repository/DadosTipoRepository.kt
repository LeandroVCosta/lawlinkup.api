package lawlinkup.Projeto.lawLinkup.repository

<<<<<<< Updated upstream
import lawlinkup.Projeto.lawLinkup.usuario.tipo.Tipo
=======
import lawlinkup.Projeto.lawLinkup.domain.Tipo
>>>>>>> Stashed changes
import org.springframework.data.jpa.repository.JpaRepository

interface DadosTipoRepository : JpaRepository<Tipo, Long> {
}