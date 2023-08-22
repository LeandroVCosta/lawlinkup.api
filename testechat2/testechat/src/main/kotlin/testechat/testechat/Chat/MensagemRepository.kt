package testechat.testechat.Chat

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MensagemRepository:JpaRepository <Mensagem,Long> {
    @Query("select m from Mensagem m where m.remetente = ?1 or m.destinatario = ?1")
    fun findAllByRemetenteOrDestinatario(userId:Usuario):List<Mensagem>
}