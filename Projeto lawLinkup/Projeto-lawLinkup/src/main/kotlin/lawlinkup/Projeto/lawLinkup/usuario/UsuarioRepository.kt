package lawlinkup.Projeto.lawLinkup.usuario

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.security.core.userdetails.UserDetails

interface UsuarioRepository : JpaRepository<Usuario, Long> {
    @Query("""
        SELECT u FROM Usuario u
        WHERE u.nome LIKE %?1% 
    """)
     fun findByNomeUsuario(nome:String): List<Usuario?>

    fun findByEmailAndSenha(email: String, senha: String): Usuario
    @Query("""
       SELECT u FROM Usuario u JOIN u.tipoUsuario tp
    """)
    fun findBuscaUsuarioPorTipo(): List<Usuario?>

}