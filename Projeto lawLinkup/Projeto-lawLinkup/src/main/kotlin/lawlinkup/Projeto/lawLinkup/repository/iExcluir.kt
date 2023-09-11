package lawlinkup.Projeto.lawLinkup.repository

import org.springframework.http.ResponseEntity

interface iExcluir<T> {

   fun excluir(idUsuario:Long):ResponseEntity<T>
}