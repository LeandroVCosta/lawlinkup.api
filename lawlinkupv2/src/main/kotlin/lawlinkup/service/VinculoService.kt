package lawlinkup.service

import lawlinkup.domain.Vinculo
import lawlinkup.dto.requests.VinculoRequest
import lawlinkup.repository.AdvogadoRepository
import lawlinkup.repository.CasoRepository
import lawlinkup.repository.VinculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class VinculoService {

    @Autowired
    lateinit var vinculoRepository: VinculoRepository

    @Autowired
    lateinit var casoRepository: CasoRepository

    @Autowired
    lateinit var advogadoRepository: AdvogadoRepository

    fun cadastrarVinculo(request: VinculoRequest):ResponseEntity<Vinculo>{
        val advogado = advogadoRepository.findById(request.idAdvogado).get()
        val caso = casoRepository.findById(request.idCaso).get()

        val vinculo = Vinculo(request,advogado,caso)

        vinculoRepository.save(vinculo)

        return ResponseEntity.status(201).body(vinculo)
    }

    fun listarVinculo(idCaso: Long, idAdvogado: Long): ResponseEntity<Vinculo?> {
        val vinculo = vinculoRepository.findByCasoAndAdvogado(idCaso, idAdvogado)
        return ResponseEntity.status(200).body(vinculo)
    }

}