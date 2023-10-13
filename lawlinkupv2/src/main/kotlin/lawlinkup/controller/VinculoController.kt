package lawlinkup.controller

import lawlinkup.domain.Vinculo
import lawlinkup.dto.requests.VinculoRequest
import lawlinkup.service.VinculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vinculo")
class VinculoController {
    @Autowired
    val service: VinculoService = VinculoService()

    @PostMapping("/cadastrar")
    fun cadastrarVinculo(dadosVinculo: VinculoRequest): ResponseEntity<Vinculo> {
        return service.cadastrarVinculo(dadosVinculo)
    }
}