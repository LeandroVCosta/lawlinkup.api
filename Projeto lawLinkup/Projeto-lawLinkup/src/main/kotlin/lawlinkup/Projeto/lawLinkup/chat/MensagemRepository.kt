package lawlinkup.Projeto.lawLinkup.chat

import org.springframework.data.jpa.repository.JpaRepository

interface MensagemRepository: JpaRepository <Mensagem, Long> {
        fun findByFkCasoOrderByDataMensagem(fkCaso:Int):MutableList<Mensagem>
}