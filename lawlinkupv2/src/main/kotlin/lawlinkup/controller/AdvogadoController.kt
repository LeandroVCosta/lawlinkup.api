package lawlinkup.controller

import lawlinkup.dto.UsuarioResponse
import lawlinkup.lawlinkupv2.domain.Advogado
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
    fun cadastrarAdvogado(@RequestBody user: Advogado): UsuarioResponse {
        return service.cadastrarAdvogado(user)
    }

}