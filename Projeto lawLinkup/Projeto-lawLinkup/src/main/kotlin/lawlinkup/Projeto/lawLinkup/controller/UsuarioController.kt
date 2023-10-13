package lawlinkup.Projeto.lawLinkup.controller

import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.dtos.DadosEditarAdvogadoDto
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario
import lawlinkup.Projeto.lawLinkup.domain.Usuario
import lawlinkup.Projeto.lawLinkup.dtos.UsuarioDto
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.repository.DadosTipoRepository
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
    @GetMapping("/tipo/user")
    fun tipoUsuario():ResponseEntity<List<Usuario?>>{
        val buscaUsuario = usuarioRepository.findBuscaUsuarioPorTipo()
        if (buscaUsuario.isNotEmpty()){
            return ResponseEntity.status(200).body(buscaUsuario)
        }
        return ResponseEntity.status(404).build()
    }


}
