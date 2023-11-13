package lawlinkup.Projeto.lawLinkup.controller
import lawlinkup.Projeto.lawLinkup.domain.Mensagem
import lawlinkup.Projeto.lawLinkup.dto.CarregarMensagensDTO
import lawlinkup.Projeto.lawLinkup.dto.DadosSocketDTO
import lawlinkup.Projeto.lawLinkup.repository.MensagemRepository
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/chat")
class ChatController () {

        @Autowired
        lateinit var usuarioRepository: UsuarioRepository

        @Autowired
        lateinit var repository: MensagemRepository
        @PostMapping
        fun enviarMensagem(@RequestBody dadosMensagem:Mensagem):ResponseEntity<String>{
                val mensagem = repository.save(dadosMensagem)
                return ResponseEntity.status(201).body("Mensagem enviada com sucesso!")
        }

        @PostMapping("/atualizarSocketId")
        fun atualizarSocketId(@RequestBody dados:DadosSocketDTO):ResponseEntity<String>{
                val user = usuarioRepository.findById(dados.idUsuario).get()
                user.socketId = dados.socketId
                usuarioRepository.save(user)
                return ResponseEntity.status(200).body(dados.socketId)
        }

        @PostMapping("/carregarMensagens")
        fun carregarMensagem(@RequestBody dados: CarregarMensagensDTO){

        }

}