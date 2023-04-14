package lawlinkup.Projeto.lawLinkup.advogado

import org.springframework.data.jpa.repository.JpaRepository

interface AdvogadoRepository : JpaRepository<Advogado, Long>{
    fun findAllByAtivoTrue(): MutableList<Advogado>
}