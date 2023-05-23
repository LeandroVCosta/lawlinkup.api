package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.autenticacao.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.autenticacao.DadosUsuarioDto
import lawlinkup.Projeto.lawLinkup.autenticacao.Usuario
import lawlinkup.Projeto.lawLinkup.cliente.Cliente
import lawlinkup.Projeto.lawLinkup.cliente.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.ResponseEntity
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import com.sun.security.auth.UserPrincipal
import lawlinkup.Projeto.lawLinkup.advogado.Advogado
import lawlinkup.Projeto.lawLinkup.advogado.AdvogadoRepository
import lawlinkup.Projeto.lawLinkup.tipo.Tipo
import java.io.FileInputStream
import java.io.IOException
import java.nio.file.Paths
import java.time.LocalDateTime

@RestController
@RequestMapping("/login")
class UsuarioController() {

//    @Autowired
    lateinit var repository: UsuarioRepository

    @Autowired
    lateinit var clienteRepository: ClienteRepository

    @Autowired
    lateinit var advogadoRepository: AdvogadoRepository

    @PostMapping
    fun logarUser(@RequestBody @Valid dados: DadosUsuarioDto): ResponseEntity<Any> {

        if (dados.tipo.equals(Tipo.CLIENTE)){
        val cliente = clienteRepository.findByEmailAndSenha(dados.email, dados.senha)
            clienteRepository.save(cliente.copy(ultimaSessao = LocalDateTime.now()))
            return ResponseEntity.status(200).body(cliente)
        }
        if (dados.tipo.equals(Tipo.ADVOGADO)){
            val advogado = advogadoRepository.findByEmailAndSenha(dados.email, dados.senha)
            advogadoRepository.save(advogado.copy(ultimaSessao = LocalDateTime.now()))
            return ResponseEntity.status(200).body(advogado)
        }
        return ResponseEntity.status(401).build()
        }


//    @PostMapping("/logoff/{id}")
//    fun deslogarUser(@PathVariable id: Long): ResponseEntity<Unit> {
//        val cliente = repository.findById(id)
//
//        val advogado = advogadoRepository.findById(id)
//
//        if (!cliente.isEmpty) {
//            cliente.get().deslogarUsuario()
//            repository.save(cliente.get())
//            advogadoRepository.save(advogado.get())
//            return ResponseEntity.status(200).build()
//        }
//        return ResponseEntity.status(204).build()
//    }


}

