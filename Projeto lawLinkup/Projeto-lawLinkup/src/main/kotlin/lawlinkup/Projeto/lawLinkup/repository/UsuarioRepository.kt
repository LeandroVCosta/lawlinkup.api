package lawlinkup.Projeto.lawLinkup.repository


import lawlinkup.Projeto.lawLinkup.domain.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UsuarioRepository : JpaRepository<Usuario, Long> {
    @Query(""" SELECT u FROM Usuario u 
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

    fun findByEmailAndSenha(email: String, senha: String): Usuario
    @Query("""
       SELECT u FROM Usuario u JOIN u.tipoUsuario tp
    """)
    fun findBuscaUsuarioPorTipo(): List<Usuario?>

    @Query("""
        SELECT visitas FROM Usuario u WHERE u.id = ?1 
    """)
    fun findByTotalVisitas(id:Long):Int
    @Query("""
        SELECT u FROM Usuario u GROUP BY especializacao
    """)
    fun findByAgruparAdvogadoPorEspecializacao():List<Usuario>
}