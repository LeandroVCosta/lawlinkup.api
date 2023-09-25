package lawlinkup.repository

import Advogado
import org.springframework.data.jpa.repository.JpaRepository

interface AdvogadoRepository : JpaRepository <Advogado,Long> {

}