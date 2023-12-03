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
        SELECT distinct(u.especializacao) FROM Usuario u WHERE u.especializacao IS NOT NULL
    """)
    fun findEspecializacao():List<String>
    @Query("""
        SELECT a, ROUND(AVG(v.avaliacao), 2) AS avaliacao, COUNT(v.avaliacao) as qtdAvaliacao
        FROM Usuario a
        LEFT JOIN Vinculo v ON a.idUsuario = v.advogado.id
        JOIN a.tipoUsuario tu 
        WHERE tu.nome = 'ADVOGADO' 
        AND a.especializacao = ?1
        GROUP BY a.idUsuario
    """)
<<<<<<< HEAD
    fun findAdvogadosByEspecializacao(especializacao:String):List<Usuario>

//    @Query("""
//        SELECT DATE_FORMAT(u.dataVisita, '%Y-%m') as mesAno, COUNT (u.visitas) as quantidadeTotal from Usuario u
//        WHERE idUsuario = ?1 AND tipoUsuario = 1
//    """)

    @Query("""
        SELECT DATE_FORMAT(u.dataVisita, '%Y-%m') as mesAno, 
        COUNT(u.visitas) as quantidadeTotal FROM Usuario u
        WHERE u.id = ?1 GROUP BY mesAno ORDER BY mesAno AND tipoUsuario = 1 
    """)
    fun quantidadeVisitasMensais(id:Long): List<DadosMensais>
=======
    fun findAdvogadosByEspecializacao(especializacao:String):List<Array<Any>>

    @Query("""
        SELECT a, ROUND(AVG(v.avaliacao), 2) AS avaliacao, COUNT(v.avaliacao) as qtdAvaliacao
        FROM Usuario a
        LEFT JOIN Vinculo v ON a.idUsuario = v.advogado.id
        JOIN a.tipoUsuario tu 
        WHERE tu.nome = 'ADVOGADO' 
        GROUP BY a.idUsuario
    """)
    fun findAllAdvogadoAndAvaliacaoAndQtdAvaliacao():List<Array<Any>>
>>>>>>> bb09dbf25844ba836f002f9811253d9eeaf37327
}