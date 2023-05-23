package lawlinkup.Projeto.lawLinkup.controller

import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.advogado.AdvogadoRepository
import lawlinkup.Projeto.lawLinkup.cliente.ClienteRepository
import lawlinkup.Projeto.lawLinkup.cliente.caso.CasoRepository
import lawlinkup.Projeto.lawLinkup.cliente.vinculo.AtualizarOrcamentoDto
import lawlinkup.Projeto.lawLinkup.cliente.vinculo.DadosVinculoDto
import lawlinkup.Projeto.lawLinkup.cliente.vinculo.Vinculo
import lawlinkup.Projeto.lawLinkup.cliente.vinculo.VinculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vinculo")
class VinculoController {
    @Autowired
    lateinit var vinculoRepository: VinculoRepository

    @Autowired
    lateinit var casoRepository: CasoRepository

    @Autowired
    lateinit var advogadoRepository: AdvogadoRepository

    @Autowired
    lateinit var clienteRepository: ClienteRepository

    @PostMapping
    fun postVinculo(@RequestBody @Valid dados: DadosVinculoDto): ResponseEntity<Vinculo> {

        val advogado = advogadoRepository.findById(dados.advogadoId)
        val caso = casoRepository.findById(dados.casoId)
        val cliente = clienteRepository.findById(dados.clienteId)

        if (!caso.isEmpty || !advogado.isEmpty ) {
        val vinculo = vinculoRepository.save(Vinculo(dados, advogado.get(), caso.get(), cliente.get()))
        return ResponseEntity.status(201).body(vinculo)
        }
        return ResponseEntity.status(400).build()
    }

    @PatchMapping("/orcamento")
    fun patchOrcamento(@RequestBody @Valid dados:AtualizarOrcamentoDto, @PathVariable id:Long): ResponseEntity<Any>{
    val buscarVinculo = vinculoRepository.findById(id)

     if (!buscarVinculo.isEmpty){
        buscarVinculo.get().orcamento = dados.orcamemento
        vinculoRepository.save(buscarVinculo.get())
         return ResponseEntity.status(204).build()
     }
        return ResponseEntity.status(400).build()
    }


}