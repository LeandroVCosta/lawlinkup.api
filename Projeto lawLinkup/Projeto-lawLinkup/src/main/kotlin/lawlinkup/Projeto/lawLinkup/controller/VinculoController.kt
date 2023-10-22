package lawlinkup.Projeto.lawLinkup.controller

import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import lawlinkup.Projeto.lawLinkup.domain.Registro
import lawlinkup.Projeto.lawLinkup.domain.Vinculo
import lawlinkup.Projeto.lawLinkup.dto.DadosRegistro
import lawlinkup.Projeto.lawLinkup.dtos.AtualizarDadosVinculoDto
import lawlinkup.Projeto.lawLinkup.dtos.DadosVinculoDto
import lawlinkup.Projeto.lawLinkup.repository.CasoRepository
import lawlinkup.Projeto.lawLinkup.repository.RegistroRepository
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

@RestController
@RequestMapping("/vinculo")
class VinculoController {
    @Autowired
    lateinit var vinculoRepository: VinculoRepository

    @Autowired
    lateinit var casoRepository: CasoRepository

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository;

    @Autowired
    lateinit var registroRepository: RegistroRepository;
    @PostMapping
    fun postVinculo(@RequestBody @Valid dados: DadosVinculoDto): ResponseEntity<Vinculo> {

        val advogado = usuarioRepository.findById(dados.advogadoId)
        val caso = casoRepository.findById(dados.casoId)

        if (!caso.isEmpty &&
            !advogado.isEmpty && advogado.get().tipoUsuario?.nome == "ADVOGADO") {
        val vinculo = vinculoRepository.save(Vinculo(dados, advogado.get(), caso.get()))
            val registro = Registro()
            registro.status = "CASO_EM_ANDAMENTO"

            registro.vinculo = vinculo

            registroRepository.save(registro)

        return ResponseEntity.status(201).body(vinculo)
        }

        return ResponseEntity.status(400).build()
    }

    @PatchMapping("/atualizar/{id}")
    fun patchDadosVinculo(@RequestBody @Valid dados: AtualizarDadosVinculoDto, @PathVariable id:Long): ResponseEntity<Any>{
    val buscarVinculo = vinculoRepository.findById(id)

     if (!buscarVinculo.isEmpty){
        buscarVinculo.get().avaliacao = dados.avaliacao
       val vinculo = vinculoRepository.save(buscarVinculo.get())

         val registro = Registro()
         registro.status = "CASO_FINALIZADO"

         registro.vinculo = vinculo

         registroRepository.save(registro)

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

}