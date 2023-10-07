package lawlinkup.Projeto.lawLinkup.repository

import lawlinkup.Projeto.lawLinkup.domain.Usuario
import lawlinkup.Projeto.lawLinkup.dto.DadosEditarCasoDto
import org.springframework.http.ResponseEntity

interface iEditar<T> {

   fun editar(id:Long, t: T):ResponseEntity<T>
}