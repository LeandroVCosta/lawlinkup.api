package lawlinkup.service

import lawlinkup.domain.users.Advogado
import lawlinkup.dto.requests.AdvogadoRequest
import lawlinkup.dto.requests.LoginRequest
import lawlinkup.dto.requests.perfilAdvogadoRequest
import lawlinkup.dto.responses.perfilAdvogadoResponse
import lawlinkup.repository.AdvogadoRepository
import lawlinkup.repository.TipoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class AdvogadoService {


    @Autowired
    lateinit var advogadoRepository:AdvogadoRepository

    @Autowired
    lateinit var tipoRepository:TipoRepository

    fun cadastrarAdvogado(request: AdvogadoRequest): ResponseEntity<Advogado> {
        val tipo = tipoRepository.findById(1).get()

        val advogado = Advogado(request,tipo)

        advogadoRepository.save(advogado)
        return ResponseEntity.status(201).body(advogado)
    }

    fun buscarAdvogado(id:Long):ResponseEntity<Advogado>{
        val advogado = advogadoRepository.findById(id).get()
        return ResponseEntity.status(200).body(advogado)
    }

    fun logar(request: LoginRequest):ResponseEntity<Advogado>{
        val advogado = advogadoRepository.findByEmailAndSenha(request.email,request.senha)
        return ResponseEntity.status(200).body(advogado)
    }

    fun atualizarPerfil(request: perfilAdvogadoRequest):ResponseEntity<perfilAdvogadoResponse>{
        val advogado = advogadoRepository.findById(request.idAdvogado).get()

        advogado.sobre = request.sobre
        advogado.especializacao = request.especializacao
        advogado.nome = request.nome

        advogadoRepository.save(advogado)
        val dadosAtualizados = perfilAdvogadoResponse(advogado.nome,advogado.especializacao,advogado.sobre)
        return ResponseEntity.status(200).body(dadosAtualizados)
    }
}