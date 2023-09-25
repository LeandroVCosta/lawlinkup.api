package lawlinkup.service

import Advogado
import lawlinkup.dto.UsuarioResponse
import lawlinkup.repository.AdvogadoRepository
import org.springframework.beans.factory.annotation.Autowired

class AdvogadoService {

    @Autowired
    lateinit var advogadoRepository:AdvogadoRepository

    fun cadastrarAdvogado(user:Advogado):UsuarioResponse{
        advogadoRepository.save(user)
        return UsuarioResponse(user.nome,user.email,user.sobre)
    }

}