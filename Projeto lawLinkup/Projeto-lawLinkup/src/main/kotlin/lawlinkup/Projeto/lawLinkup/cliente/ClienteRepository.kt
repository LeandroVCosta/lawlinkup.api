package lawlinkup.Projeto.lawLinkup.cliente

import org.springframework.data.jpa.repository.JpaRepository

interface ClienteRepository : JpaRepository<Cliente, Long>{
    abstract fun findAllByAtivoTrue(): MutableList<Cliente>
    abstract fun findAllById(id: Long): MutableList<Cliente>
}