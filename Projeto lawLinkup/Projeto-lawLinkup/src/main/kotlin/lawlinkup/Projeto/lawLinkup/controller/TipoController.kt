package lawlinkup.Projeto.lawLinkup.controller

import lawlinkup.Projeto.lawLinkup.usuario.tipo.DadosTipoRepository
import lawlinkup.Projeto.lawLinkup.usuario.tipo.Tipo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tipoUsuario")
class TipoController  {

    @Autowired
    lateinit var tipoRepository: DadosTipoRepository


    @GetMapping
    fun getTipo(): ResponseEntity<MutableList<Tipo>> {
        val buscaTipo = tipoRepository.findAll();
        if (!buscaTipo.isNotEmpty()){
            return ResponseEntity.status(200).body(buscaTipo)
        }
            return ResponseEntity.status(404).build()

    }
}