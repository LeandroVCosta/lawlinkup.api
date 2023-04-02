package lawlinkup.Projeto.lawLinkup.autenticacao

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByLoginAndSenha(login: String, senha: String): UserDetails
}