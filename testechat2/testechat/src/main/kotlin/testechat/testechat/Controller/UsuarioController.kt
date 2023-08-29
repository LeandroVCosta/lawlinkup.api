package testechat.testechat.Controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import testechat.testechat.Chat.*

@RestController()
@RequestMapping("/usuario")
class UsuarioController {

    @Autowired
    lateinit var repository:UsuarioRepository

    @Autowired
    lateinit var mensagemRepository: MensagemRepository

    @PostMapping("/cadastrar")
    fun cadastrarUsuario(@RequestBody u:Usuario):ResponseEntity<Usuario>{
            repository.save(u)
        return ResponseEntity.status(201).body(u)
    }

    @PostMapping("/historico")
    fun listarHistorico(@RequestBody userId:Long): ResponseEntity<List<Mensagem>> {

        val usuario = repository.findById(userId).get()
        val historico = mensagemRepository.findAllByRemetenteOrDestinatario(usuario)

        return ResponseEntity.status(201).body(historico)

    }

    @PatchMapping()
    fun atualizarSocketId (@RequestBody u:Usuario):ResponseEntity<Usuario>{
        repository.setSocketId(u.idUsuario,u.socketId)
        return ResponseEntity.status(204).body(null)
    }


}