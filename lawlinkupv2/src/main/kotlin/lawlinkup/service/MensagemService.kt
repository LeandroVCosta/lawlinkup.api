package lawlinkup.service

import lawlinkup.domain.Mensagem
import lawlinkup.dto.requests.MensagemRequest
import lawlinkup.repository.MensagemRepository
import lawlinkup.repository.UsuarioRepository
import lawlinkup.repository.VinculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MensagemService {

    @Autowired
    lateinit var repository: MensagemRepository

    @Autowired
    lateinit var userRepository: UsuarioRepository

    lateinit var vinculoRepository: VinculoRepository

    fun enviarMensagem(mensagem:MensagemRequest):ResponseEntity<Mensagem>{

        val vinculo = vinculoRepository.findById(mensagem.vinculo).get()
        
        val remetente = userRepository.findById(mensagem.remetente).get()
        val destinatario = userRepository.findById(mensagem.destinatario).get()

        val mensagem = Mensagem(mensagem,vinculo,remetente, destinatario)

        repository.save(mensagem)

        return ResponseEntity.status(201).body(mensagem)
    }
}