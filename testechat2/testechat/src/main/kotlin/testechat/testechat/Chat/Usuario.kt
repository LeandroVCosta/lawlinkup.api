package testechat.testechat.Chat

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "usuario")
@Entity(name = "Usuario")
class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idUsuario:Long,
    val nome:String,
    val socketId:String
)