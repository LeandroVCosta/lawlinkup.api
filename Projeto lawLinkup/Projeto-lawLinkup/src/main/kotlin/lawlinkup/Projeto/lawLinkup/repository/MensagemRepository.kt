package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Mensagem
import lawlinkup.Projeto.lawLinkup.domain.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MensagemRepository : JpaRepository <Mensagem,Long> {

    @Query("""
        SELECT m FROM Mensagem m
            WHERE m.vinculo.id = ?1
    """)
    fun getAllByVinculo(vinculo:Long):List<Mensagem>
}