package lawlinkup.Projeto.lawLinkup.controller

import lawlinkup.Projeto.lawLinkup.domain.Caso
import lawlinkup.Projeto.lawLinkup.repository.CasoRepository
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.repository.VinculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dashboard")
class DashboardController {

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository
    @Autowired
    lateinit var casoRepository: CasoRepository

    @Autowired
    lateinit var vinculoRepository: VinculoRepository

    @GetMapping("/cliente/{id}")
    fun dashMediaAvaliacao(@PathVariable id: Long): ResponseEntity<Any>{

        val buscaAvalicao = vinculoRepository.findByMediaAvaliacaoCaso(id)
        if (buscaAvalicao != null) {
            return  ResponseEntity.status(200).body(buscaAvalicao)
            }
            return ResponseEntity.status(204).build()
        }

    @GetMapping("/cliente/casos/{id}")
    fun listCasosFinalizados(id: Long): ResponseEntity<List<Caso>> {
    val buscaCasos = casoRepository.findByCasoFinalizado(id)
        if (!buscaCasos.isEmpty()){
            return ResponseEntity.status(200).body(buscaCasos)
        }
            return ResponseEntity.status(204).build()
    }


    }



