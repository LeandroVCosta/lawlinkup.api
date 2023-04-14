package lawlinkup.Projeto.lawLinkup.controller

import lawlinkup.Projeto.lawLinkup.autenticacao.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.autenticacao.DadosUsuarioDto
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val repository: UsuarioRepository) {


    @PostMapping
    fun logarUser(@RequestBody dados: DadosUsuarioDto): ResponseEntity<UserDetails> {
        val cliente = repository.findByEmailAndSenha(dados.login, dados.senha)
        if(!cliente.isEnabled){
            return ResponseEntity.status(401).build()
        }
        return ResponseEntity.status(200).body(cliente)
    }

}