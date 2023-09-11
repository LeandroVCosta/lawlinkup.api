package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.domain.Caso
import lawlinkup.Projeto.lawLinkup.dtos.DadosCasoDto
import lawlinkup.Projeto.lawLinkup.repository.CasoRepository
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.repository.iExcluir
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/caso")
class CasoController (
    val casoRepository: CasoRepository,
                      val usuarioRepository: UsuarioRepository) : iExcluir<Caso> {


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


    @DeleteMapping("{id}")
    override fun excluir(@PathVariable id: Long): ResponseEntity<Caso> {
        val excluir = casoRepository.deleteById(id)
        return ResponseEntity.status(204).build()

    }

}