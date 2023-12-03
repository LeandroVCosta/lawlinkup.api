package lawlinkup.Projeto.lawLinkup.controller

import BucketMethods
import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.dtos.DadosEditarAdvogadoDto
import lawlinkup.Projeto.lawLinkup.enuns.TipoUsuario
import lawlinkup.Projeto.lawLinkup.domain.Usuario
import lawlinkup.Projeto.lawLinkup.dtos.UsuarioDto
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.repository.DadosTipoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.IOException

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

    @PostMapping("/subirimagem", consumes = ["multipart/form-data"])
    fun uploadImage(@RequestParam("tipo") tipo: String, @RequestParam("stringByte") file: MultipartFile): ResponseEntity<String> {
        try {
            val byteArray = file.bytes // Obtendo os bytes do arquivo MultipartFile
            val imageUrl = BucketMethods().subirImagem(tipo, byteArray)
            return ResponseEntity.ok().body(imageUrl)
        } catch (e: IOException) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a imagem")
        }
    }
}
