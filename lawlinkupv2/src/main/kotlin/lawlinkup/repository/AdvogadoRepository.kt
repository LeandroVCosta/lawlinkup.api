package lawlinkup.repository

import lawlinkup.domain.users.Advogado
import lawlinkup.dto.responses.advogadoAvaliacaoResponse
import lawlinkup.dto.responses.perfilAdvogadoResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AdvogadoRepository : JpaRepository <Advogado,Long> {
    fun findByEmailAndSenha(email:String,senha:String):Advogado


    @Query("""
       SELECT a FROM advogado a 
         WHERE a.nome LIKE %?1%
    """)
    fun findAllByNome(nome:String):List<Advogado>

    @Query("SELECT NEW lawlinkup.dto.responses.advogadoAvaliacaoResponse(a, AVG(v.avaliacao)) FROM advogado a JOIN vinculo v ON v.advogado.id = a.id GROUP BY a.id ORDER BY AVG(v.avaliacao) DESC")
    fun findAllOrderByAvaliacao():List<advogadoAvaliacaoResponse?>
}