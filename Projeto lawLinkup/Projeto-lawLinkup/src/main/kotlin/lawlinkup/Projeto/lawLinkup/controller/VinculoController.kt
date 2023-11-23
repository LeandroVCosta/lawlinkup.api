package lawlinkup.Projeto.lawLinkup.controller

import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.domain.Registro
import lawlinkup.Projeto.lawLinkup.domain.Vinculo
import lawlinkup.Projeto.lawLinkup.dtos.AtualizarDadosVinculoDto
import lawlinkup.Projeto.lawLinkup.dtos.DadosVinculoDto
import lawlinkup.Projeto.lawLinkup.repository.CasoRepository
import lawlinkup.Projeto.lawLinkup.repository.RegistroRepository
import lawlinkup.Projeto.lawLinkup.repository.UsuarioRepository
import lawlinkup.Projeto.lawLinkup.repository.VinculoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ArrayBlockingQueue

@RestController
@CrossOrigin("*")
@RequestMapping("/vinculo")
class VinculoController {
    @Autowired
    lateinit var vinculoRepository: VinculoRepository

    @Autowired
    lateinit var casoRepository: CasoRepository

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository;

    @Autowired
    lateinit var registroRegistroRepository: RegistroRepository

    @PostMapping
    fun postVinculo(@RequestBody @Valid dados: DadosVinculoDto): ResponseEntity<Vinculo> {

        val advogado = usuarioRepository.findById(dados.advogadoId)
        val caso = casoRepository.findById(dados.casoId)
        val registro = Registro()
        val status = "AGUARDANDO_RESPOSTA"
        dados.situacao = status
        registro.status = status
        if (!caso.isEmpty &&
                !advogado.isEmpty && advogado.get().tipoUsuario?.nome == "ADVOGADO") {
            val vinculo = vinculoRepository.save(Vinculo(dados, advogado.get(), caso.get()))
            registro.vinculo = vinculo
            registroRegistroRepository.save(registro)
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

    @GetMapping("/{idVinculo}")
    fun getVinculoPorId(@PathVariable idVinculo:Long): ResponseEntity<Vinculo>{
        val vinculos = vinculoRepository.findById(idVinculo)
        if (!vinculos.isEmpty()){
            return ResponseEntity.status(200).body(vinculos.get())
        }
        return ResponseEntity.status(204).build()
    }


    @GetMapping("/listarPorAdvogado/{idAdvogado}")
    fun listarVinculoAdvogado(@PathVariable idAdvogado:Long):ResponseEntity<ArrayBlockingQueue<Vinculo>>{
        val vinculos = vinculoRepository.findVinculoByAdvogado(idAdvogado)
        val solicitacoesOrdenadas = ArrayBlockingQueue<Vinculo>(vinculos.size)
        solicitacoesOrdenadas.addAll(vinculos.sortedBy { it.dataCriacao })
        if (vinculos.isEmpty()){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(solicitacoesOrdenadas)
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
        val registro = Registro()
        val status = "ACEITO"
        registro.vinculo = vinculo
        registro.status = status
        vinculo.situacao = status
        registroRegistroRepository.save(registro)
        vinculoRepository.save(vinculo)
        return ResponseEntity.status(200).build()
    }

    @PatchMapping("/rejeitar/{idVinculo}")
    fun rejeitarVinculo(@PathVariable idVinculo:Long):ResponseEntity<Unit>{
        var vinculo = vinculoRepository.findById(idVinculo).get()
        val registro = Registro()
        val status = "REJEITADO"
        registro.vinculo = vinculo
        registro.status = status
        vinculo.situacao = status
        registroRegistroRepository.save(registro)
        vinculoRepository.save(vinculo)
        return ResponseEntity.status(200).build()
    }

    @PatchMapping("/finalizar/{idVinculo}")
    fun finalizarVinculo(@PathVariable idVinculo:Long, @RequestBody @Valid dados: AtualizarDadosVinculoDto):ResponseEntity<Unit>{
        val buscarVinculo = vinculoRepository.findById(idVinculo)
        val registro = Registro()
        val status = "FINALIZADO"
        if (!buscarVinculo.isEmpty){
            val vinculo = buscarVinculo.get()
            registro.vinculo = vinculo
            registro.status = status
            vinculo.situacao = status
            vinculo.avaliacao = dados.avaliacao
            vinculo.comentario = dados.comentario
            registroRegistroRepository.save(registro)
            vinculoRepository.save(vinculo)
            return ResponseEntity.status(200).build()
        }
        return ResponseEntity.status(400).build()
    }

    @PatchMapping("/solicitarFimCliente/{idVinculo}")
    fun solicitarFimCliente(@PathVariable idVinculo:Long):ResponseEntity<Unit>{
        var vinculo = vinculoRepository.findById(idVinculo).get()
        val registro = Registro()
        val status = "CLIENTE_ENCERRADO"
        registro.vinculo = vinculo
        registro.status = status
        vinculo.situacao = status
        registroRegistroRepository.save(registro)
        vinculoRepository.save(vinculo)
        return ResponseEntity.status(200).build()
    }

    @PatchMapping("/solicitarFimAdvogado/{idVinculo}")
    fun solicitarFimAdvogado(@PathVariable idVinculo:Long):ResponseEntity<Unit>{
        var vinculo = vinculoRepository.findById(idVinculo).get()
        val registro = Registro()
        val status = "ADVOGADO_ENCERRADO"
        registro.vinculo = vinculo
        registro.status = status
        vinculo.situacao = status
        registroRegistroRepository.save(registro)
        vinculoRepository.save(vinculo)
        return ResponseEntity.status(200).build()
    }

}