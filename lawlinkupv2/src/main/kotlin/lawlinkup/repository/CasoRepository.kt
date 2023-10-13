package lawlinkup.repository

import lawlinkup.domain.Caso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CasoRepository : JpaRepository <Caso,Long> {
    @Query(
        """
            select c from caso c JOIN c.cliente c1 where c1.id = ?1
        """
    )
    fun findByCliente(idCliente:Long):List<Caso?>
}