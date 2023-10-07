package lawlinkup.controller

import lawlinkup.dto.requests.AdvogadoRequest
import lawlinkup.dto.responses.UsuarioResponse
import lawlinkup.service.AdvogadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/advogado")
class AdvogadoController {

    @Autowired
    val service:AdvogadoService = AdvogadoService()

    @PostMapping("/cadastrar")
    fun cadastrarAdvogado(@RequestBody user: AdvogadoRequest): UsuarioResponse {
        return service.cadastrarAdvogado(user)
    }

}