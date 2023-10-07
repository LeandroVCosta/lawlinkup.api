package lawlinkup.Projeto.lawLinkup.controller

import lawlinkup.Projeto.lawLinkup.domain.Caso
import lawlinkup.Projeto.lawLinkup.domain.Usuario
import lawlinkup.Projeto.lawLinkup.dto.DadosEditarCasoDto
import lawlinkup.Projeto.lawLinkup.repository.CasoRepository
import lawlinkup.Projeto.lawLinkup.repository.DadosTipoRepository
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.repository.iEditar
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("usuario/cliente")
class ClienteController : iEditar<DadosEditarCasoDto>{

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    @Autowired
    lateinit var dadosCasoRepository: CasoRepository

    @PatchMapping("editar/{idCaso}")
    override fun editar(
        @PathVariable  idCaso: Long,
        @RequestBody dados: DadosEditarCasoDto): ResponseEntity<DadosEditarCasoDto> {
        val buscaCaso = dadosCasoRepository.findById(idCaso)
        if (!buscaCaso.isEmpty ){
            buscaCaso.get().detalhamento = dados.detalhamento
            buscaCaso.get().especificacao = dados.especificacao
            buscaCaso.get().servico = dados.servico
            val caso = buscaCaso.get()
            dadosCasoRepository.save(caso)
            return ResponseEntity.status(200).build()
        }
            return ResponseEntity.status(404).build()
    }

}