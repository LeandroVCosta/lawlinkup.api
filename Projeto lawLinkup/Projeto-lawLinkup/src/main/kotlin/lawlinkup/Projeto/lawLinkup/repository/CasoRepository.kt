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
//    @Query("""
//        SELECT c From Caso c where c.id
//        not in (select v.caso.id from Vinculo
//        v where v.caso.id = c.id) or c.id in
//         (select v.caso.id from Vinculo
//        v where v.caso.id = c.id and v.situacao = "REJEITADO" and c.id not in (select l.caso.id from Vinculo l where l.situacao = "ACEITO" or l.situacao = "AGUARDANDO_RESPOSTA" or l.situacao = "FINALIZADO"))""")
//    fun findByCliente(fkCliente: Int):List<Caso>

    @Query("""
        SELECT c From Caso c JOIN c.cliente cl WHERE cl.id = ?1 and c.id
        not in (select v.caso.id from Vinculo v where 
        v.caso.id = c.id and (
        v.situacao = "AGUARDANDO_RESPOSTA" or 
        v.situacao = "ACEITO" or 
        v.situacao="ORCAMENTO_PENDENTE" or 
        v.situacao="ORCAMENTO_ACEITO" or 
        v.situacao="ORCAMENTO_REJEITADO" or 
        v.situacao="CLIENTE_ENCERRADO" or
        v.situacao="ADVOGADO_ENCERRADO" or
        v.situacao = "FINALIZADO"))""")
    fun findByCliente(fkCliente: Int):List<Caso>
}