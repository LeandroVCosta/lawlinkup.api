package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.autenticacao.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.autenticacao.DadosUsuarioDto
import lawlinkup.Projeto.lawLinkup.autenticacao.Usuario
import lawlinkup.Projeto.lawLinkup.cliente.Cliente
import lawlinkup.Projeto.lawLinkup.cliente.ClienteRepository
import org.springframework.context.annotation.Bean
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuarios")
class UsuarioController(private val repository: UsuarioRepository) {


    @PostMapping("/login/{id}")
    fun logarUser(@RequestBody @Valid dados: DadosUsuarioDto, @PathVariable id:Long): ResponseEntity<UserDetails> {
        val usuario = repository.findByEmailAndSenha(dados.login, dados.senha)
        val idUsuario = repository.findById(id)
        if(!idUsuario.isEmpty){
            idUsuario.get().logarUsuario()
            repository.save(idUsuario.get())
            return ResponseEntity.status(200).body(usuario)
        }

            return ResponseEntity.status(204).build()
    }

    @PostMapping("/logoff/{id}")
    fun deslogarUser(@PathVariable id:Long): ResponseEntity<Unit>{
        val cliente = repository.findById(id)
        if (!cliente.isEmpty){
            cliente.get().deslogarUsuario()
            repository.save(cliente.get())
            return  ResponseEntity.status(200).build()
        }

        return ResponseEntity.status(204).build()
    }

}