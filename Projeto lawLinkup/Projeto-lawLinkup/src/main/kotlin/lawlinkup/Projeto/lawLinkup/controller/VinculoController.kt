package lawlinkup.Projeto.lawLinkup.controller

import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.domain.Vinculo
import lawlinkup.Projeto.lawLinkup.dtos.AtualizarDadosVinculoDto
import lawlinkup.Projeto.lawLinkup.dtos.DadosVinculoDto
import lawlinkup.Projeto.lawLinkup.repository.CasoRepository
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.repository.VinculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ArrayBlockingQueue

@RestController
@RequestMapping("/vinculo")
class VinculoController {
    @Autowired
    lateinit var vinculoRepository: VinculoRepository

    @Autowired
    lateinit var casoRepository: CasoRepository

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository;

    @PostMapping
    fun postVinculo(@RequestBody @Valid dados: DadosVinculoDto): ResponseEntity<Vinculo> {

        val advogado = usuarioRepository.findById(dados.advogadoId)
        val caso = casoRepository.findById(dados.casoId)
        dados.situacao = "AGUARDANDO_RESPOSTA"

        if (!caso.isEmpty &&
                !advogado.isEmpty && advogado.get().tipoUsuario?.nome == "ADVOGADO") {
            val vinculo = vinculoRepository.save(Vinculo(dados, advogado.get(), caso.get()))
            return ResponseEntity.status(201).body(vinculo)
        }

        return ResponseEntity.status(400).build()
    }

    @PatchMapping("/atualizar/{id}")
    fun patchDadosVinculo(@RequestBody @Valid dados: AtualizarDadosVinculoDto, @PathVariable id:Long): ResponseEntity<Any>{
        val buscarVinculo = vinculoRepository.findById(id)

        if (!buscarVinculo.isEmpty){
            buscarVinculo.get().avaliacao = dados.avaliacao
            buscarVinculo.get().comentario = dados.comentario
            vinculoRepository.save(buscarVinculo.get())
            return ResponseEntity.status(200).build()
        }
        return ResponseEntity.status(400).build()
    }

    @GetMapping()
    fun getVinculo(): ResponseEntity<MutableList<Vinculo>>{
        val viculos = vinculoRepository.findAll()
        if (!viculos.isEmpty()){
            return ResponseEntity.status(200).body(viculos)
        }
        return ResponseEntity.status(204).build()
    }

    @GetMapping("/listarPorAdvogado/{idAdvogado}")
    fun listarVinculoAdvogado(@PathVariable idAdvogado:Long):ResponseEntity<List<Vinculo>>{
        val vinculos = vinculoRepository.findVinculoByAdvogado(idAdvogado)
        if (vinculos.isEmpty()){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(vinculos)
    }

    @GetMapping("/listarPorCliente/{idCliente}")
    fun listarVinculoCliente(@PathVariable idCliente:Long):ResponseEntity<List<Vinculo>>{
        val vinculos = vinculoRepository.findVinculoByCliente(idCliente)
        if (vinculos.isEmpty()){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(vinculos)
    }

    @GetMapping("/listarSolicitacoes/{idAdvogado}")
    fun listarSolicitacoesAdvogado(@PathVariable idAdvogado:Long):ResponseEntity<ArrayBlockingQueue<Vinculo>>{

        val solicitacoes = vinculoRepository.findVinculoSolicitacaoByAdvogado(idAdvogado,"AGUARDANDO_RESPOSTA")
        val solicitacoesOrdenadas = ArrayBlockingQueue<Vinculo>(solicitacoes.size)

        if (solicitacoes.isEmpty()){
            return ResponseEntity.status(204).body(null)
        }
        solicitacoesOrdenadas.addAll(solicitacoes.sortedBy { it.dataCriacao })
        return ResponseEntity.status(200).body(solicitacoesOrdenadas)
    }

    @PatchMapping("/aceitar/{idVinculo}")
    fun aceitarVinculo(@PathVariable idVinculo:Long):ResponseEntity<Unit>{
        var vinculo = vinculoRepository.findById(idVinculo).get()
        vinculo.situacao = "ACEITO"
        vinculoRepository.save(vinculo)
        return ResponseEntity.status(200).build()
    }

    @PatchMapping("/rejeitar/{idVinculo}")
    fun rejeitarVinculo(@PathVariable idVinculo:Long):ResponseEntity<Unit>{
        var vinculo = vinculoRepository.findById(idVinculo).get()
        vinculo.situacao = "REJEITADO"
        vinculoRepository.save(vinculo)
        return ResponseEntity.status(200).build()
    }

}