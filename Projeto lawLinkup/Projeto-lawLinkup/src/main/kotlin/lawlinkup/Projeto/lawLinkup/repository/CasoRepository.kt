package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Caso
import lawlinkup.Projeto.lawLinkup.domain.Registro
import lawlinkup.Projeto.lawLinkup.domain.Vinculo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CasoRepository : JpaRepository<Caso, Long> {
    @Query("""
        SELECT c FROM Caso c JOIN c.cliente cl WHERE cl.id = ?1
    """)
    fun findAllCaso(fkCliente:Int): List<Caso>?


}