package lawlinkup.repository

import lawlinkup.domain.users.Advogado
import org.springframework.data.jpa.repository.JpaRepository

interface AdvogadoRepository : JpaRepository <Advogado,Long> {
    fun findByEmailAndSenha(email:String,senha:String):Advogado
}