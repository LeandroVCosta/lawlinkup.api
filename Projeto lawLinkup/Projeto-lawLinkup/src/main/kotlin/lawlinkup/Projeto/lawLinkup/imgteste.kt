package lawlinkup.Projeto.lawLinkup

import lawlinkup.Projeto.lawLinkup.utils.configuracao.BucketMethods

fun main() {
    val bucket = BucketMethods()
    bucket.subirImagem(tipo = "perfil", byteArray = "Algo Incrivel".toByteArray())
}

