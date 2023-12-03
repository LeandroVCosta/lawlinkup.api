package lawlinkup.Projeto.lawLinkup.controller
import lawlinkup.Projeto.lawLinkup.domain.Mensagem
import lawlinkup.Projeto.lawLinkup.dto.CarregarMensagensDTO
import lawlinkup.Projeto.lawLinkup.dto.DadosMensagemDTO
import lawlinkup.Projeto.lawLinkup.dto.DadosSocketDTO
import lawlinkup.Projeto.lawLinkup.repository.MensagemRepository
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.repository.VinculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chat")
class MensagemController() {

        @Autowired
        lateinit var usuarioRepository: UsuarioRepository

        @Autowired
        lateinit var vinculoRepository: VinculoRepository

        @Autowired
        lateinit var repository: MensagemRepository
        @PostMapping("/enviarmensagem")

        fun enviarMensagem(@RequestBody dadosMensagem:DadosMensagemDTO):ResponseEntity<String>{

                val destinatario = usuarioRepository.findById(dadosMensagem.idDestinatario).get()
                val remetente = usuarioRepository.findById(dadosMensagem.idRemetente).get()
                val vinculo = vinculoRepository.findById(dadosMensagem.idVinculo).get()

                val mensagem = Mensagem(null,vinculo,remetente,destinatario,dadosMensagem.mensagem)
                repository.save(mensagem)

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
        fun carregarMensagem(@RequestBody dados: CarregarMensagensDTO):ResponseEntity<List<Mensagem?>>{
                val mensagens = repository.getAllByVinculo(dados.idVinculo)

                if (mensagens.isEmpty()){
                        return ResponseEntity.status(204).build()
                }

                return ResponseEntity.status(200).body(mensagens)

        }

        @GetMapping("/buscarSocketId/{id}")
        fun buscarSocketPorIdUsuario(@PathVariable id:Long):ResponseEntity<String?>{
                val socket = usuarioRepository.findById(id).get().socketId
                return ResponseEntity.status(200).body(socket)
        }

}