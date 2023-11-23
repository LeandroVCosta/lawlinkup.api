package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Vinculo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface VinculoRepository : JpaRepository<Vinculo, Long>{

    @Query("""
         SELECT ROUND(AVG(v.avaliacao), 2) 
         FROM Vinculo v, Caso c, Usuario u 
         WHERE v.caso.cliente.id = ?1
    """)
    fun findByMediaAvaliacaoCaso(id:Long): Double?


    @Query("""
        SELECT COUNT(*) FROM Vinculo v WHERE v.advogado.id = ?1
    """)
    fun findByTotalVinculosAdvogados(id:Long): Int

    @Query("""
        SELECT DATE_FORMAT(v.dataCriacao, '%Y-%m') as mesAno, COUNT(*) as quantidadeCasos FROM Vinculo v 
        WHERE v.advogado.id = ?1 GROUP BY mesAno ORDER BY mesAno
    """)
    fun findByQtdVinculosMensais(id:Long):List<VinculosMensais>

    @Query("""
        SELECT v from Vinculo v WHERE v.advogado.id = ?1 and (situacao = "ACEITO" or situacao = "AGUARDANDO_RESPOSTA" or situacao="ORCAMENTO_ACEITO" or situacao="ORCAMENTO_PENDENTE" or situacao="ORCAMENTO_REJEITADO" or situacao="ADVOGADO_ENCERRADO" or situacao="CLIENTE_ENCERRADO" or situacao = "FINALIZADO")
    """)
    fun findVinculoByAdvogado(id:Long):List<Vinculo>

    @Query("""
        SELECT v from Vinculo v WHERE v.caso.cliente.id = ?1 and (situacao = "ACEITO" or situacao="ORCAMENTO_ACEITO" or situacao="ORCAMENTO_PENDENTE" or situacao="ORCAMENTO_REJEITADO" or situacao="ADVOGADO_ENCERRADO" or situacao="CLIENTE_ENCERRADO" or situacao = "FINALIZADO")
    """)
    fun findVinculoByCliente(id:Long):List<Vinculo>

    @Query("""
        SELECT v from Vinculo v WHERE v.advogado.id = ?1 and v.situacao = ?2
    """)
    fun findVinculoSolicitacaoByAdvogado(id:Long, situacao:String):List<Vinculo>
}