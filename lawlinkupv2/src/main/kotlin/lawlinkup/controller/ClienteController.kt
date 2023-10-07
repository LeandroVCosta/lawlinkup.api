package lawlinkup.controller
import lawlinkup.dto.responses.UsuarioResponse
import lawlinkup.dto.requests.ClienteRequest
import lawlinkup.service.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cliente")

class ClienteController {

    @Autowired
    val service:ClienteService = ClienteService()
    @PostMapping("/cadastrar")
    fun cadastrarCliente(user: ClienteRequest): UsuarioResponse {
        return service.cadastrarCliente(user)
    }

}