package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.advogado.Advogado
import lawlinkup.Projeto.lawLinkup.advogado.AdvogadoRepository
import lawlinkup.Projeto.lawLinkup.advogado.AtualizarAdvogadoDto
import lawlinkup.Projeto.lawLinkup.advogado.DadosAdvogadosDto
import lawlinkup.Projeto.lawLinkup.advogado.assinatura.AtualizarAssinatura
import lawlinkup.Projeto.lawLinkup.cliente.Cliente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/advogado")
class AdvogadoController() {


    @Autowired
    lateinit var repository: AdvogadoRepository

    @PostMapping
    fun cadastroAdvogado(@RequestBody @Valid dados: DadosAdvogadosDto): ResponseEntity<Advogado> {
        var advogado = repository.save(Advogado(dados))
        return ResponseEntity.status(201).body(advogado);
    }

    @GetMapping
    fun listarAdvogado(): ResponseEntity<MutableList<Advogado>> {
        var listaAdvogados = repository.findAll()
        if(listaAdvogados.isEmpty()){
            return ResponseEntity.status(204).build()

        }
        return ResponseEntity.status(200).body(listaAdvogados)
    }

    @DeleteMapping("/excluir/{id}")
    fun excluirAdvogado(@PathVariable id: Long): ResponseEntity<Unit> {
        var excluir = repository.findById(id)
        var buscar = repository.findAll()
        if (!excluir.isEmpty && buscar.isNotEmpty()) {
            repository.deleteById(id)
            return ResponseEntity.status(200).build()
        }
        return ResponseEntity.status(204).build()
    }

    @PatchMapping("/atualizarPerfil/{id}")
    fun atualizarPerfil(@RequestBody @Valid atualizacao: AtualizarAdvogadoDto, @PathVariable id: Long): ResponseEntity<Any> {
        val dados = repository.findById(id)
        if (!dados.isEmpty) {
            dados.get().nome = atualizacao.nome
            dados.get().especializacao = atualizacao.especializacao
            dados.get().sobre = atualizacao.sobre
            repository.save(dados.get())
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(400).build()
    }

}