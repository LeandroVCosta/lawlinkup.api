package lawlinkup.Projeto.lawLinkup.utils

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import java.io.FileInputStream
import java.io.IOException
import java.nio.file.Paths

class BucketMethods {
    @Throws(IOException::class)
    fun subirImagem(destinoBlob: String, caminhoArquivo: String)
    {
        val projectId =  "lawlinkup"
        val bucketName = "lawlinkup_site_assets"

        val storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(
            GoogleCredentials.fromStream(
                FileInputStream("c:/Users/ocana/Documents/lawlinkup-27612faffcd1.json")
            )).build().service

        val blobId = BlobId.of(bucketName, destinoBlob)

        val blobInfo = BlobInfo.newBuilder(blobId).build()

        val precondition: Storage.BlobWriteOption = if (storage[bucketName, destinoBlob] == null) {
            Storage.BlobWriteOption.doesNotExist()
        } else {
            Storage.BlobWriteOption.generationMatch(
                storage[bucketName, destinoBlob].generation)
        }

        storage.createFrom(blobInfo, Paths.get(caminhoArquivo), precondition)
        println("File $caminhoArquivo uploaded to bucket $bucketName as $destinoBlob")
    }
}