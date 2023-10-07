package lawlinkup.service

import lawlinkup.dto.responses.UsuarioResponse
import lawlinkup.domain.users.Cliente
import lawlinkup.dto.requests.ClienteRequest
import lawlinkup.repository.ClienteRepository
import lawlinkup.repository.TipoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class ClienteService {

    @Autowired
    lateinit var repository:ClienteRepository

    @Autowired
    lateinit var tipoRepository: TipoRepository

    fun cadastrarCliente(user: ClienteRequest): UsuarioResponse {
        val tipo = tipoRepository.findById(user.tipoUsuario).get()
        val cliente = Cliente(user,tipo)
        repository.save(cliente)

        return UsuarioResponse(user.nome,user.email,user.genero)
    }

}