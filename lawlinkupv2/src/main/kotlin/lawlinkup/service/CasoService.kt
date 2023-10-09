package lawlinkup.service

import lawlinkup.domain.Caso
import lawlinkup.domain.users.Usuario
import lawlinkup.dto.requests.CasoRequest
import lawlinkup.repository.CasoRepository
import lawlinkup.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CasoService {

    @Autowired
    lateinit var casoRepository: CasoRepository

    @Autowired
    lateinit var clienteRepository: ClienteRepository

    fun cadastrarCaso(request: CasoRequest):ResponseEntity<Caso>{

        val cliente = clienteRepository.findById(request.cliente).get()

        val caso = Caso(request,cliente)

        casoRepository.save(caso)
        return ResponseEntity.status(200).body(caso)
    }

    fun buscarCasos(idCliente:Long):ResponseEntity<List<Caso?>>{
        val caso = casoRepository.findByCliente(idCliente)
        if (caso.isEmpty()){
            return ResponseEntity.status(204).body(null)
        }
        return ResponseEntity.status(200).body(caso)
    }

}