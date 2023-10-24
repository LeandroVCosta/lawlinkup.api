package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.domain.Caso
import lawlinkup.Projeto.lawLinkup.dtos.DadosCasoDto
import lawlinkup.Projeto.lawLinkup.repository.CasoRepository
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/caso")
class CasoController {

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    @Autowired
    lateinit var casoRepository: CasoRepository

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
    @GetMapping("/listarCasosInativos/{idCliente}")
    fun listarCasos(@PathVariable idCliente:Int):ResponseEntity<List<Caso>>{
        val casos = casoRepository.findByCliente(idCliente)
        if (casos.isEmpty()){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(casos)
    }
}