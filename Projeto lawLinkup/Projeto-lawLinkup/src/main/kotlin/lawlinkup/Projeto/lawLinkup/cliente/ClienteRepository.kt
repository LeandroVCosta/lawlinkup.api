package lawlinkup.Projeto.lawLinkup.cliente

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface ClienteRepository : JpaRepository<Cliente, Long>{
//    abstract fun findAllByAtivoTrue(): MutableList<Cliente>
    abstract fun findByEmailAndSenha(email: String, senha: String): Cliente
}