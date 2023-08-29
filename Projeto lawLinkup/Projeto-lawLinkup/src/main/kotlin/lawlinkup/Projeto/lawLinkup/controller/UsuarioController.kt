package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.usuario.advogado.AtualizarAdvogadoDto
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario
import lawlinkup.Projeto.lawLinkup.usuario.Usuario
import lawlinkup.Projeto.lawLinkup.usuario.UsuarioDto
import lawlinkup.Projeto.lawLinkup.usuario.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.usuario.tipo.DadosTipoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioController {

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    @Autowired
    lateinit var dadosTipoRepository: DadosTipoRepository

    @PostMapping
    fun postUsuario(@RequestBody @Valid  dados: UsuarioDto): ResponseEntity<Usuario>{
        val tipo = dadosTipoRepository.findById(dados.tipoUsuarioId)
        var user = usuarioRepository.save(Usuario(dados, tipo.get()))
        return ResponseEntity.status(201).body(user)
    }
    @GetMapping
    fun getUsuario(): ResponseEntity<MutableList<Usuario>> {
        var getUsers = usuarioRepository.findAll()
        if (getUsers.isEmpty()){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(getUsers)
    }
    @PatchMapping("atualizarPerfil/{id}")
    fun atualizarPerfil(@RequestBody @Valid atualizacao: AtualizarAdvogadoDto, @PathVariable idUsuario: Long, dadosUsuario: UsuarioDto): ResponseEntity<Any> {
        val dados = usuarioRepository.findById(idUsuario)
        if (!dados.isEmpty && dadosUsuario.tipoUsuarioId.equals(TipoUsuario.ADVOGADO) ) {
            dados.get().nome = atualizacao.nome
            dados.get().especializacao = atualizacao.especializacao
            dados.get().sobre = atualizacao.sobre
            usuarioRepository.save(dados.get())
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(400).build()
    }

    @GetMapping("/{nome}")
    fun buscarPorNome(@PathVariable nome:String): ResponseEntity<List<Usuario?>>{
     var buscaUsuarioNome = usuarioRepository.findByNomeUsuario(nome)
        return ResponseEntity.status(200).body(buscaUsuarioNome)
        }

    @GetMapping("/tipo/user")
    fun tipoUsuario():ResponseEntity<List<Usuario?>>{
        val buscaUsuario = usuarioRepository.findBuscaUsuarioPorTipo()
        if (buscaUsuario.isNotEmpty()){
            return ResponseEntity.status(200).body(buscaUsuario)
        }
            return ResponseEntity.status(404).build()
    }
}