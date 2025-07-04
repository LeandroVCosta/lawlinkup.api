package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.autenticacao.LoginRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import lawlinkup.Projeto.lawLinkup.autenticacao.DadosLoginDto
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario
import lawlinkup.Projeto.lawLinkup.usuario.UsuarioRepository
import java.time.LocalDateTime

@RestController
@RequestMapping("/login")
class LoginController() {

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    @PostMapping()
    fun logarUser(@RequestBody @Valid dados: DadosLoginDto): ResponseEntity<Any> {
    var usuario =  usuarioRepository.findByEmailAndSenha(dados.email, dados.senha)
    return ResponseEntity.status(200).body(usuario)
    }


}

