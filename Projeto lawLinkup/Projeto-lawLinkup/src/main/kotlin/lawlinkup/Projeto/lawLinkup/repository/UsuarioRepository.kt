package lawlinkup.Projeto.lawLinkup.repository

<<<<<<< Updated upstream
import lawlinkup.Projeto.lawLinkup.usuario.Usuario
=======
import lawlinkup.Projeto.lawLinkup.domain.Usuario
>>>>>>> Stashed changes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UsuarioRepository : JpaRepository<Usuario, Long> {
    @Query("""
<<<<<<< Updated upstream
        SELECT u FROM Usuario u
        WHERE u.nome LIKE %?1% 
    """)
     fun findByNomeUsuario(nome:String): List<Usuario?>
=======
         SELECT u FROM Usuario u 
         JOIN u.tipoUsuario tu 
         WHERE tu.nome = 'ADVOGADO' 
     """)
    fun findAllByNomeUsuarioAndTipoUsuarioAdvogado(): List<Usuario>

    @Query("""
          SELECT u FROM Usuario u 
         JOIN u.tipoUsuario tu 
         WHERE tu.nome = 'ADVOGADO' 
         AND u.nome LIKE %?1%

    """)
    fun findAllByNomeUsuario(nome:String): List<Usuario>
>>>>>>> Stashed changes

    fun findByEmailAndSenha(email: String, senha: String): Usuario
    @Query("""
       SELECT u FROM Usuario u JOIN u.tipoUsuario tp
    """)
    fun findBuscaUsuarioPorTipo(): List<Usuario?>

}