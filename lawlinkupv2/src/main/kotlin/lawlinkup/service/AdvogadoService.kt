package lawlinkup.service

import lawlinkup.domain.users.Advogado
import lawlinkup.dto.requests.AdvogadoRequest
import lawlinkup.dto.responses.UsuarioResponse
import lawlinkup.repository.AdvogadoRepository
import lawlinkup.repository.TipoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AdvogadoService {


    @Autowired
    lateinit var advogadoRepository:AdvogadoRepository

    @Autowired
    lateinit var tipoRepository:TipoRepository

    fun cadastrarAdvogado(user:AdvogadoRequest): UsuarioResponse {
        val tipo = tipoRepository.findById(user.tipoUsuario).get()

        val advogado = Advogado(user,tipo)

        advogadoRepository.save(advogado)
        return UsuarioResponse(user.nome,user.email,user.sobre)
    }

}