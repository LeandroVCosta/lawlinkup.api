package lawlinkup.repository

import lawlinkup.domain.users.Advogado
import lawlinkup.dto.responses.perfilAdvogadoResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AdvogadoRepository : JpaRepository <Advogado,Long> {
    fun findByEmailAndSenha(email:String,senha:String):Advogado

}