package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.usuario.cliente.caso.Caso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CasoRepository : JpaRepository<Caso, Long> {
    @Query("""
        SELECT c FROM Caso c JOIN c.cliente cl WHERE cl.id = ?1
    """)
    fun findAllCaso(fkCliente:Int): List<Caso>?

}