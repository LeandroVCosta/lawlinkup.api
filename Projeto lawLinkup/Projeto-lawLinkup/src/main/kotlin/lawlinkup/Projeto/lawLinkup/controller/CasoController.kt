package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.usuario.cliente.caso.Caso
import lawlinkup.Projeto.lawLinkup.repository.CasoRepository
import lawlinkup.Projeto.lawLinkup.usuario.cliente.caso.DadosCasoDto
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/caso")
class CasoController (val casoRepository: CasoRepository, val usuarioRepository: UsuarioRepository) {


    @PostMapping
    fun postCaso(@RequestBody @Valid dados: DadosCasoDto): ResponseEntity<Caso> {

        val cliente = usuarioRepository.findById(dados.clienteId)

        if (!cliente.isEmpty && cliente.get().tipoUsuario?.nome == "CLIENTE") {
            var caso = casoRepository.save(Caso(dados, cliente.get()))
            return ResponseEntity.status(201).body(caso)
        }
        return ResponseEntity.status(400).build()
    }

    @GetMapping("{fkCliente}")
    fun getCaso(@PathVariable fkCliente: Int): ResponseEntity<List<Caso>> {
        val casos = casoRepository.findAllCaso(fkCliente)
            return ResponseEntity.status(200).body(casos)
        }

}