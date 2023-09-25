package lawlinkup.service

import lawlinkup.dto.UsuarioResponse
import lawlinkup.lawlinkupv2.domain.Cliente
import lawlinkup.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired

class ClienteService {

    @Autowired
    lateinit var repository:ClienteRepository

    fun cadastrarCliente(user:Cliente):UsuarioResponse{
        repository.save(user)
        return UsuarioResponse(user.nome,user.email,user.genero)
    }

}