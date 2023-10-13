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

    @Query("""
        SELECT a,avg(avaliacao) FROM advogado a
           JOIN vinculo v
           ON v.advogado.id = a.id
           group by a.id
           order by avaliacao desc
    """)
    fun findAllOrderByAvaliacao():List<advogadoAvaliacaoResponse>
}