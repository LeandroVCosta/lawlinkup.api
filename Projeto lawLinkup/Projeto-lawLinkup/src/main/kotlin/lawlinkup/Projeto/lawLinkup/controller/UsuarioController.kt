package lawlinkup.Projeto.lawLinkup.controller

import lawlinkup.Projeto.lawLinkup.autenticacao.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.cliente.Cliente
import lawlinkup.Projeto.lawLinkup.cliente.ClienteRepository
import lawlinkup.Projeto.lawLinkup.cliente.DadosCadastroCliente
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val repository: UsuarioRepository) {

    @PostMapping
    fun logarUser(dados:DadosCadastroCliente): ResponseEntity<UserDetails> {
        val cliente = repository.findByLoginAndSenha(dados.email, dados.senha)
        return ResponseEntity.status(200).body(cliente)
    }

}