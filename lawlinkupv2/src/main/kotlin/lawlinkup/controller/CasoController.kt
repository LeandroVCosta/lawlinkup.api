package lawlinkup.controller

import lawlinkup.domain.Caso
import lawlinkup.dto.requests.CasoRequest
import lawlinkup.service.CasoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/caso")

class CasoController {

    @Autowired
    val service: CasoService = CasoService()

    @PostMapping("/cadastrar")
    fun cadastrarCaso(case:CasoRequest):ResponseEntity<Caso>{
        return service.cadastrarCaso(case)
    }
}