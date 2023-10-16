package lawlinkup.controller

import lawlinkup.domain.Mensagem
import lawlinkup.dto.requests.MensagemRequest
import lawlinkup.service.MensagemService
import lawlinkup.service.VinculoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mensagem")
class MensagemController {

    @Autowired
    val service: MensagemService = MensagemService()

    @PostMapping("/enviar")
    fun enviarMensagem(@RequestBody mensagem:MensagemRequest):ResponseEntity<Mensagem>{
        return service.enviarMensagem(mensagem)
    }
}