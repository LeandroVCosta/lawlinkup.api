package lawlinkup.Projeto.lawLinkup.utils

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import java.awt.image.BufferedImage
import java.io.*
import java.util.*
import javax.imageio.ImageIO


class BucketMethods {
    @Throws(IOException::class)
    fun subirImagem(tipo:String, byteArray:ByteArray):String
    {
        val bImage = FileInputStream("c:/Users/ocana/Downloads/bancos.png")
        val image = ByteArrayInputStream(bImage.readAllBytes())

        val uuid = UUID.randomUUID().toString()

        val projectId =  "lawlinkup"
        val bucketName = "lawlinkup_site_assets"
        val destinoBlob = "fotos_perfil/$uuid/$tipo.txt"

        val storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(
            GoogleCredentials.fromStream(
                FileInputStream("c:/Users/ocana/Documents/lawlinkup-27612faffcd1.json")
            )).build().service

        val blobId = BlobId.of(bucketName, destinoBlob)

        val blobInfo = BlobInfo.newBuilder(blobId).build()

        ByteArrayInputStream(byteArray).use { inputStream ->
            storage.create(blobInfo, inputStream)
        }

        return uuid
    }
}