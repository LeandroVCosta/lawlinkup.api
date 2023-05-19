package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.cliente.ClienteRepository
import lawlinkup.Projeto.lawLinkup.cliente.caso.Caso
import lawlinkup.Projeto.lawLinkup.cliente.caso.CasoRepository
import lawlinkup.Projeto.lawLinkup.cliente.caso.DadosCasoDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/caso")
class CasoController (val casoRepository: CasoRepository, val clienteRepository: ClienteRepository) {


    @PostMapping
    fun postCaso(@RequestBody @Valid dados: DadosCasoDto): ResponseEntity<Caso> {

        val cliente = clienteRepository.findById(dados.clienteId)

        if (cliente.isEmpty) {
            return ResponseEntity.status(404).build()
        }

        var caso = casoRepository.save(Caso(dados, cliente.get()))
        return ResponseEntity.status(201).body(caso)
    }

    @GetMapping("{fkCliente}")
    fun getCaso(@PathVariable fkCliente: Int): ResponseEntity<List<Caso>> {
        val casos = casoRepository.findAllCaso(fkCliente)
            return ResponseEntity.status(200).body(casos)
        }

}