package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Registro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RegistroRepository : JpaRepository<Registro, Long>{

@Query("""
        SELECT r.status AS status, c.servico as tipoServico, c.especificacao as especificacao, 
        u.nome AS nomeAdvogado
        FROM Registro r
        JOIN r.vinculo.caso c
        JOIN r.vinculo.advogado u
        WHERE r.vinculo.caso.cliente.id = ?1 AND r.status = 'FINALIZADO'
      """)
fun findByRegistrosFinalizado(id: Long): List<RegistroProjection>






}