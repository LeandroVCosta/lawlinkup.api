package lawlinkup.Projeto.lawLinkup.controller

import lawlinkup.Projeto.lawLinkup.repository.DadosTipoRepository
import lawlinkup.Projeto.lawLinkup.usuario.abstrata.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cadastro/cliente")
class ClienteController {


    @Autowired
   lateinit var  usuarioAbsRepository: UsuarioAbsRepository

   @Autowired
   lateinit var tipoRepository: DadosTipoRepository
    @PostMapping
    fun postCliente(cliente: ClienteAbstract): ResponseEntity<ClienteAbstract> {
        val user = usuarioAbsRepository.save(cliente)
        return ResponseEntity.status(201).body(user)

    }



}