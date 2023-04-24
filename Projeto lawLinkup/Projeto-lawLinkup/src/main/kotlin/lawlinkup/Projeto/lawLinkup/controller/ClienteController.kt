package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Null
import lawlinkup.Projeto.lawLinkup.cliente.Cliente
import lawlinkup.Projeto.lawLinkup.cliente.ClienteDto
import lawlinkup.Projeto.lawLinkup.cliente.DadosCadastroClienteDto
import lawlinkup.Projeto.lawLinkup.cliente.ClienteRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/cliente")
class ClienteController(private val repository: ClienteRepository) {

    @PostMapping
    fun cadastroUser(@RequestBody @Valid dados:DadosCadastroClienteDto): ResponseEntity<ClienteDto> {
        var cliente = repository.save(Cliente(dados))
        return ResponseEntity.status(201).body(cliente.toDTO())
    }

    @GetMapping
    fun listaruser(): ResponseEntity<MutableList<Cliente>> {
        var cliente = repository.findAllByAtivoTrue()
        return ResponseEntity.status(200).body(cliente)

    }
    @DeleteMapping("/excluir/{id}")
    fun excluirUsuario(@PathVariable id:Long): ResponseEntity<Unit>{
        var excluir = repository.findById(id)
        var buscar = repository.findAllByAtivoTrue()
        if (!excluir.isEmpty && buscar.isNotEmpty() ){
        repository.deleteById(id)
        return ResponseEntity.status(200).build()
        }
        return ResponseEntity.status(204).build()
    }



}

