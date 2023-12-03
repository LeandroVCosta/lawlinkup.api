package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.domain.Orcamento
import lawlinkup.Projeto.lawLinkup.domain.Registro
import lawlinkup.Projeto.lawLinkup.dtos.DadosOrcamentoDto
import lawlinkup.Projeto.lawLinkup.repository.OrcamentoRepository
import lawlinkup.Projeto.lawLinkup.repository.RegistroRepository
import lawlinkup.Projeto.lawLinkup.repository.VinculoRepository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orcamento")
@CrossOrigin("*")
class OrcamentoController {

    @Autowired
    lateinit var orcamentoRepository: OrcamentoRepository

    @Autowired
    lateinit var vinculoRepository: VinculoRepository

    @Autowired
    lateinit var registroRegistroRepository: RegistroRepository

    @PostMapping()
    fun postOrcamento(@RequestBody @Valid dadosOrcamento: DadosOrcamentoDto): ResponseEntity<Orcamento>{
        var vinculo = vinculoRepository.findById(dadosOrcamento.vinculoId).get()
        var orcamentoExists = orcamentoRepository.getOrcamentoPorVinculo(dadosOrcamento.vinculoId)
        val registro = Registro()
        val status = "ORCAMENTO_PENDENTE"
        if (vinculo.situacao == status){
            return ResponseEntity.status(403).build()
        }
        vinculo.situacao = status
        registro.vinculo = vinculo
        registro.status = status
        registroRegistroRepository.save(registro)
        if (orcamentoExists.isEmpty) {
            val orcamento = orcamentoRepository.save(Orcamento(dadosOrcamento, vinculo))
            return ResponseEntity.status(201).body(orcamento)
        }
            val newOrcamento = orcamentoExists.get()
            newOrcamento.valorOrcamento = dadosOrcamento.valorOrcamento
            newOrcamento.prazoFinal = dadosOrcamento.prazoFinal
            val orcamento = orcamentoRepository.save(newOrcamento)
            return ResponseEntity.status(201).body(orcamento)
        }
    @GetMapping("{id}")
    fun getOrcamento(@PathVariable id:Long): ResponseEntity<Orcamento>{
        var orcamento = orcamentoRepository.getOrcamentoPorVinculo(id).get()
        return ResponseEntity.status(200).body(orcamento)
    }
    @PatchMapping("aceitarOrcamento/{id}")
    fun aceitarOrcamento(@PathVariable id:Long): ResponseEntity<Unit>{
        var vinculo = vinculoRepository.findById(id).get()
        val registro = Registro()
        val status = "ORCAMENTO_ACEITO"
        registro.vinculo = vinculo
        registro.status = status
        vinculo.situacao = status
        registroRegistroRepository.save(registro)
        vinculoRepository.save(vinculo)
        return ResponseEntity.status(200).build()
    }

    @PatchMapping("rejeitarOrcamento/{id}")
    fun rejeitarOrcamento(@PathVariable id:Long): ResponseEntity<Unit>{
        var vinculo = vinculoRepository.findById(id).get()
        val registro = Registro()
        val status = "ORCAMENTO_REJEITADO"
        registro.vinculo = vinculo
        registro.status = status
        vinculo.situacao = status
        registroRegistroRepository.save(registro)
        vinculoRepository.save(vinculo)
        return ResponseEntity.status(200).build()
    }



}