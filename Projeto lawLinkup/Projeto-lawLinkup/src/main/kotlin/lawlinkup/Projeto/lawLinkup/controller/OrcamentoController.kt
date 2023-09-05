package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.usuario.advogado.orcamento.Orcamento
import lawlinkup.Projeto.lawLinkup.repository.OrcamentoRepository
import lawlinkup.Projeto.lawLinkup.usuario.advogado.orcamento.dadosOrcamentoDto
import lawlinkup.Projeto.lawLinkup.repository.VinculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orcamento")
class OrcamentoController {

    @Autowired
    lateinit var orcamentoRepository: OrcamentoRepository

    @Autowired
    lateinit var vinculoRepository: VinculoRepository

    @PostMapping()
    fun postOrcamento(@RequestBody @Valid dadosOrcamento: dadosOrcamentoDto): ResponseEntity<Orcamento>{
    var vinculo = vinculoRepository.findById(dadosOrcamento.vinculoId)
    if (vinculo.isEmpty){
    val orcamento = orcamentoRepository.save(Orcamento(dadosOrcamento, vinculo.get()))
    return ResponseEntity.status(201).body(orcamento)
    }
    return ResponseEntity.status(400).build()
    }
}