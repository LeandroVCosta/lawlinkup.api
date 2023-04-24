package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.advogado.Advogado
import lawlinkup.Projeto.lawLinkup.advogado.AdvogadoRepository
import lawlinkup.Projeto.lawLinkup.advogado.DadosAdvogadosDto
import lawlinkup.Projeto.lawLinkup.cliente.Cliente
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/advogados")
class AdvogadoController(private val repository:AdvogadoRepository) {
    @PostMapping
    fun cadastroAdvogado(@RequestBody @Valid dados:DadosAdvogadosDto): ResponseEntity<Advogado>{
        var advogado = repository.save(Advogado(dados))
        return ResponseEntity.status(201).body(advogado);
    }

    @GetMapping
    fun listarAdvogado(): ResponseEntity<MutableList<Advogado>> {
        var listaAdvogados = repository.findAllByAtivoTrue()

        return ResponseEntity.status(200).body(listaAdvogados)
    }
    @DeleteMapping("/excluir/{id}")
    fun excluirAdvogado(@PathVariable id:Long): ResponseEntity<Unit>{
        var excluir = repository.findById(id)
        if (!excluir.isEmpty){
        repository.deleteById(id)
        return ResponseEntity.status(200).build()
        }
        return ResponseEntity.status(204).build()
    }


}