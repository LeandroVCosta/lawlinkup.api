import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.Acl
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.StorageOptions
import java.io.ByteArrayInputStream
import java.io.FileInputStream
import java.io.IOException
import java.util.*

class BucketMethods {
    @Throws(IOException::class)
    fun subirImagem(tipo: String, image: ByteArray): String {
        val uuid = UUID.randomUUID().toString()
        val projectId = "lawlinkup"
        val bucketName = "lawlinkup_banco_imagens"
        val destinoBlob = "fotos_perfil/$uuid$tipo"

        val storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(
            GoogleCredentials.fromStream(
                FileInputStream("./lawlinkup-402320-04bc7fb65ea3.json")
            )
        ).build().service

        val blobId = BlobId.of(bucketName, destinoBlob)
        val blobInfo = BlobInfo.newBuilder(blobId)
            .setContentType("image/jpeg") // Defina o tipo de conteúdo corretamente, se necessário
            .build()

        storage.create(blobInfo, image)

        // Configuração para tornar o objeto público
        storage.createAcl(blobId, Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER))

        // Obtendo a URL pública do objeto
        val url = "https://storage.googleapis.com/$bucketName/$destinoBlob"

        return url
    }
}