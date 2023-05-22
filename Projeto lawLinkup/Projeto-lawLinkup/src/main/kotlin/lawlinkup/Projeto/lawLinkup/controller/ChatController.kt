package lawlinkup.Projeto.lawLinkup.controller

import lawlinkup.Projeto.lawLinkup.chat.Mensagem
import lawlinkup.Projeto.lawLinkup.chat.MensagemRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/chat")
class ChatController (val repository:MensagemRepository) {
        @PostMapping
        fun enviarMensagem(@RequestBody dadosMensagem:Mensagem):ResponseEntity<String>{
                val mensagem = repository.save(dadosMensagem)
                return ResponseEntity.status(201).body("Mensagem enviada com sucesso!")
        }

        @GetMapping
        fun atualizarMensagens(){

        }

        @PostMapping("/orcamento")
        fun enviarOrcamento() {

        }


        @GetMapping("/orcamento")
        fun receberOrcamento(){

        }

}