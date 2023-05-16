package lawlinkup.Projeto.lawLinkup.advogado

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface AdvogadoRepository : JpaRepository<Advogado, Long>{
    fun findAllByAtivoTrue(): MutableList<Advogado>
    abstract fun findByEmailAndSenha(email: String, senha: String): Advogado

}