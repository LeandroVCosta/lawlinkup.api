package lawlinkup.Projeto.lawLinkup.controller

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

    @Autowired
    lateinit var visitaRepository: VisitaRepository

    @GetMapping("/cliente/{id}")
    fun dashMediaAvaliacao(@PathVariable id: Long): ResponseEntity<Double>{

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


//    ENDPOINTS DA DASH DO ADVOGADO

    @GetMapping("/todosContatos/{id}")
    fun buscasTodosVinculosAdvogado(@PathVariable id:Long): ResponseEntity<Int> {
        val buscaVinculos = vinculoRepository.findByTotalVinculosAdvogados(id)
        return ResponseEntity.status(200).body(buscaVinculos)
    }

    @GetMapping("totalCasosEmAndamento/{id}")
    fun buscaTotalCasosEmAndamento(@PathVariable id:Long): ResponseEntity<Int>{
        val buscaTotalCasos = registroRepository.findByTotalRegistrosEmAndamento(id)
        if (buscaTotalCasos == 0){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(buscaTotalCasos)
    }

    @GetMapping("totalClientes/{id}")
    fun buscaTotalClientes(@PathVariable id:Long): ResponseEntity<Int>{
        val buscaClientes = registroRepository.findByTotalRegistrosFinalizados(id)
        if (buscaClientes == 0){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(buscaClientes)
    }

    @GetMapping("quantidadeCasosMensais/{id}")
    fun quantidadeCasosMensais(@PathVariable id:Long):ResponseEntity<List<ListaDadosMensais>>{
    val buscaCasos = vinculoRepository.findByQtdVinculosMensais(id)
        if (buscaCasos.isNotEmpty()){
            return ResponseEntity.status(200).body(buscaCasos)
        }
            return ResponseEntity.status(204).build()
    }

    @GetMapping("quantidadeVisitas/{id}")
    fun buscaTotalVisitas(@PathVariable id:Long): ResponseEntity<Int>{
        val buscaVisitas = usuarioRepository.findByTotalVisitas(id)
        if (buscaVisitas == 0){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(buscaVisitas)
    }

    @GetMapping("quantidadeVisitasMensais/{id}")
    fun buscaVisitasDadosMensais(@PathVariable id: Long): ResponseEntity<List<ListaDadosMensais>>{
        val buscaVisitas = visitaRepository.findByVisitasMensais(id)
        if (buscaVisitas.isEmpty()){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(buscaVisitas)
    }

    }



