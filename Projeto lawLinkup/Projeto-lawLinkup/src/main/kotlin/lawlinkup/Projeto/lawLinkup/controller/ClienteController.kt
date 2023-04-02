package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.cliente.Cliente
import lawlinkup.Projeto.lawLinkup.cliente.ClienteDto
import lawlinkup.Projeto.lawLinkup.cliente.DadosCadastroCliente
import lawlinkup.Projeto.lawLinkup.cliente.ClienteRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/cliente")
class ClienteController(private val repository: ClienteRepository) {

    @PostMapping
    fun cadastroUser(@RequestBody @Valid dados:DadosCadastroCliente): ResponseEntity<ClienteDto> {
        dados.ativo = true
        var cliente = repository.save(Cliente(dados))
        return ResponseEntity.status(201).body(cliente.toDTO())
    }

    @GetMapping
    fun listaruser(): ResponseEntity<MutableList<Cliente>> {
        var cliente = repository.findAllByAtivoTrue()
        return ResponseEntity.status(200).body(cliente)

    }
//
    @DeleteMapping("/{id}")
    fun desativarUsuario(@PathVariable id:Long):ResponseEntity<Unit> {
        var cliente = repository.findById(id)
        if(cliente != null && !repository.existsById(id)){
            return ResponseEntity.status(204).build()
        }
        cliente.get().exluirUsuario()
        repository.save(cliente.get())
        return ResponseEntity.status(200).build()

    }

    @PutMapping("/{id}")
    fun ativarUsuario(@PathVariable id:Long):ResponseEntity<Unit> {
        var cliente = repository.findById(id)
        if(cliente != null && !repository.existsById(id)){
            return ResponseEntity.status(204).build()
        }
        cliente.get().ativarUsuario()
        repository.save(cliente.get())
        return ResponseEntity.status(200).build()

    }



}

