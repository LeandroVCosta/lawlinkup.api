package lawlinkup.Projeto.lawLinkup.controller

import lawlinkup.Projeto.lawLinkup.domain.Usuario
import lawlinkup.Projeto.lawLinkup.dtos.DadosEditarAdvogadoDto
import lawlinkup.Projeto.lawLinkup.repository.DadosTipoRepository
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.repository.iEditar
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/usuario/advogado")
class AdvogadoController : iEditar<DadosEditarAdvogadoDto>{

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    @GetMapping("/{nome}")
    fun buscarPorNome(@PathVariable nome:String): ResponseEntity<List<Usuario>> {
        var buscaUsuarioNome = usuarioRepository.findAllByNomeUsuario(nome)
        return ResponseEntity.status(200).body(buscaUsuarioNome)
    }

    @GetMapping("/todos")
    fun retornaTodosAdvogados(): ResponseEntity<List<Usuario>> {
        val todos = usuarioRepository.findAllByNomeUsuarioAndTipoUsuarioAdvogado()
        if (todos.isNotEmpty()){
            return ResponseEntity.status(200).body(todos)
        }

        return ResponseEntity.status(204).build()
    }

    @PatchMapping("editar/{idAdvogado}")
    override fun editar(
        @PathVariable idAdvogado: Long,
        @RequestBody dados: DadosEditarAdvogadoDto): ResponseEntity<DadosEditarAdvogadoDto> {
        val buscaAdvogado = usuarioRepository.findById(idAdvogado)
        if (!buscaAdvogado.isEmpty && buscaAdvogado.get().tipoUsuario?.nome == "ADVOGADO") {
            buscaAdvogado.get().sobre = dados.sobre
            buscaAdvogado.get().especializacao = dados.especializacao
            val advogado = buscaAdvogado.get()
            usuarioRepository.save(advogado)
            return ResponseEntity.status(200).build()
        }
            return ResponseEntity.status(404).build()
    }




}