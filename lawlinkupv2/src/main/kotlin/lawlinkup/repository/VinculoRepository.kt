package lawlinkup.repository

import lawlinkup.domain.Caso
import lawlinkup.domain.Vinculo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface VinculoRepository:JpaRepository<Vinculo,Long> {

    @Query(
        """
            SELECT v FROM vinculo v 
            WHERE v.caso.cliente.id = ?1
            AND v.advogado.id = ?2
        """
    )
    fun findByCasoAndAdvogado(idCaso:Long, idAdvogado:Long):Vinculo?
}