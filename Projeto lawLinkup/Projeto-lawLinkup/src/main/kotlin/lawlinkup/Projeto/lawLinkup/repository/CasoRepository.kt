package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Caso
import lawlinkup.Projeto.lawLinkup.domain.Vinculo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CasoRepository : JpaRepository<Caso, Long> {
    @Query("""
        SELECT c FROM Caso c JOIN c.cliente cl WHERE cl.id = ?1
    """)
    fun findAllCaso(fkCliente:Int): List<Caso>?

    @Query("""
        SELECT r.idHistorico, v.dataCriacao, c.servico, 
           u.idTipo, u.nome, u.especializacao, u.sobre
    FROM Registro r
    JOIN r.vinculo v
    JOIN v.caso c
    JOIN c.cliente u
    WHERE r.status = 'FINALIZADO' AND u.id 
    """)
    fun findByCasoFinalizado(id: Long): List<Caso>


}