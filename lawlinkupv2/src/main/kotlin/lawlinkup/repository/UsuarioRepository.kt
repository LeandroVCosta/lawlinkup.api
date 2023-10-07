import lawlinkup.domain.users.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository:JpaRepository<Usuario,Long> {
}