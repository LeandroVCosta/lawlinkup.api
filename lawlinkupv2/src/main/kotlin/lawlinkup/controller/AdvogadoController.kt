package lawlinkup.controller

import lawlinkup.domain.users.Advogado
import lawlinkup.dto.requests.LoginRequest
import lawlinkup.dto.requests.AdvogadoRequest
import lawlinkup.dto.requests.perfilAdvogadoRequest
import lawlinkup.dto.responses.perfilAdvogadoResponse
import lawlinkup.service.AdvogadoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/advogado")
class AdvogadoController {

    @Autowired
    val service:AdvogadoService = AdvogadoService()

    @PostMapping("/cadastrar")
    fun cadastrarAdvogado(@RequestBody @Valid user: AdvogadoRequest): ResponseEntity<Advogado> {
        return service.cadastrarAdvogado(user)
    }

    @GetMapping("/buscar/{id}")
    fun buscarAdvogado(@PathVariable id:Long):ResponseEntity<Advogado>{
        return service.buscarAdvogado(id)
    }

    @GetMapping("/logar")
    fun login(@RequestBody dadosLogin: LoginRequest):ResponseEntity<Advogado>{
        return service.logar(dadosLogin)
    }

    @PatchMapping("/atualizarperfil")
    fun atualizarPerfil(dadosAtualizacao:perfilAdvogadoRequest):ResponseEntity<perfilAdvogadoResponse>{
        return service.atualizarPerfil(dadosAtualizacao)
    }

    @GetMapping("/listarAdvogados")
    fun listarAdvogados(){

        
    }
}