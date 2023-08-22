package testechat.testechat.Chat

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import javax.transaction.Transactional

interface UsuarioRepository:JpaRepository <Usuario,Long> {

    @Query("update Usuario u set u.socketId = ?2 where u.idUsuario = ?1")
    @Modifying
    @Transactional
    fun setSocketId(id:Long, socketId:String)


}