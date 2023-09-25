package lawlinkup.controller
import lawlinkup.dto.UsuarioResponse
import lawlinkup.lawlinkupv2.domain.Cliente
import lawlinkup.service.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cliente")

class ClienteController {

    @Autowired
    val service:ClienteService = ClienteService()

    fun cadastrarCliente(user: Cliente): UsuarioResponse {
        return service.cadastrarCliente(user)
    }

}