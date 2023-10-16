package lawlinkup.controller

import lawlinkup.domain.Vinculo
import lawlinkup.dto.requests.VinculoRequest
import lawlinkup.dto.requests.listarVinculoRequest
import lawlinkup.service.VinculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PostMapping("/exibirvinculo")
    fun exibirVinculo(@RequestBody dadosVinculo: listarVinculoRequest):ResponseEntity<Vinculo?>{
        return service.listarVinculo(dadosVinculo.idCaso,dadosVinculo.idAdvogado)
    }
}