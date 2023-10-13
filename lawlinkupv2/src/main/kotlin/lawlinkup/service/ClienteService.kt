package lawlinkup.service

import lawlinkup.domain.users.Cliente
import lawlinkup.dto.requests.ClienteRequest
import lawlinkup.dto.requests.LoginRequest
import lawlinkup.repository.ClienteRepository
import lawlinkup.repository.TipoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service

class ClienteService {

    @Autowired
    lateinit var clienteRepository:ClienteRepository

    @Autowired
    lateinit var tipoRepository: TipoRepository

    fun cadastrarCliente(user: ClienteRequest): ResponseEntity<Cliente> {
        val tipo = tipoRepository.findById(2).get()
        val cliente = Cliente(user,tipo)

        clienteRepository.save(cliente)
        return ResponseEntity.status(201).body(cliente)
    }

    fun logar(request: LoginRequest): ResponseEntity<Cliente> {
        val cliente = clienteRepository.findByEmailAndSenha(request.email,request.senha)
        return ResponseEntity.status(200).body(cliente)
    }

}