package lawlinkup.service

import lawlinkup.domain.Caso
import lawlinkup.dto.requests.CasoRequest
import lawlinkup.repository.CasoRepository
import lawlinkup.repository.ClienteRepository
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CasoService {

    @Autowired
    lateinit var casoRepository: CasoRepository

    @Autowired
    lateinit var clienteRepository: ClienteRepository

    fun cadastrarCaso(case:CasoRequest):ResponseEntity<Caso>{

        val cliente = clienteRepository.findById(case.cliente).get()

        val caso = Caso(case,cliente)
        casoRepository.save(caso)
        return ResponseEntity.status(200).body(caso)
    }

}