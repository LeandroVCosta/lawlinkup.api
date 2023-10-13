package lawlinkup.controller
import lawlinkup.domain.users.Cliente
import lawlinkup.dto.requests.ClienteRequest
import lawlinkup.dto.requests.LoginRequest
import lawlinkup.service.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cliente")

class ClienteController {

    @Autowired
    val service:ClienteService = ClienteService()
    @PostMapping("/cadastrar")
    fun cadastrarCliente(dadosCliente: ClienteRequest): ResponseEntity<Cliente> {
        return service.cadastrarCliente(dadosCliente)
    }

    @GetMapping("/logar")
    fun login(@RequestBody dadosLogin: LoginRequest): ResponseEntity<Cliente> {
        return service.logar(dadosLogin)
    }

}