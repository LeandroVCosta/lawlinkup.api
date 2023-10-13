package lawlinkup.Projeto.lawLinkup.controller

import lawlinkup.Projeto.lawLinkup.domain.Caso
import lawlinkup.Projeto.lawLinkup.domain.Registro
import lawlinkup.Projeto.lawLinkup.domain.Vinculo
import lawlinkup.Projeto.lawLinkup.repository.*
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
    lateinit var registroRepository: RegistroRepository

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

    @GetMapping("/casos/{id}")
    fun listCasosFinalizados(@PathVariable id: Long): ResponseEntity<List<RegistroProjection>> {
    val buscaCasos = registroRepository.findByRegistrosFinalizado(id)
        if (buscaCasos.isNotEmpty()){
            return ResponseEntity.status(200).body(buscaCasos)
        }
            return ResponseEntity.status(204).build()
    }


    @GetMapping("/todosContatos/{id}")
    fun buscasTodosVinculosAdvogado(@PathVariable id:Long): ResponseEntity<Int> {
        val buscaVinculos = vinculoRepository.findByTotalVinculosAdvogados(id)
        return ResponseEntity.status(200).body(buscaVinculos)
    }

//    @GetMapping("totalClientesMensais/{id}")
//    fun buscaTotalClientesMensais(@PathVariable id:Long): ResponseEntity<Int>{
//        val buscaTotalClientes =
//
//    }








    }



