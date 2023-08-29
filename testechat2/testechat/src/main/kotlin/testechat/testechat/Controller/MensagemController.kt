package testechat.testechat.Controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import testechat.testechat.Chat.*


@RestController
@RequestMapping("/mensagem")
class MensagemController  {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    @Autowired
    lateinit var repository: MensagemRepository

    @PostMapping()
    fun salvarMensagem (@RequestBody m:MensagemDTO):ResponseEntity<Mensagem>{

        val remetente = usuarioRepository.findById(m.remetente)
        val destinatario = usuarioRepository.findById(m.destinatario)

        val mensagem:Mensagem = Mensagem(m.idMensagem,m.mensagem,remetente.get(),destinatario.get())

        repository.save(mensagem)

        return ResponseEntity.status(201).body(mensagem)
    }
}