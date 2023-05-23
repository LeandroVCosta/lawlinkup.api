package lawlinkup.Projeto.lawLinkup.configuracao

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions
import java.io.FileInputStream
import java.io.IOException
import java.nio.file.Paths

class UploadObject {
    @Throws(IOException::class)
    fun uploadObject(
        projectId: String?, bucketName: String, objectName: String, filePath: String
    ) {
        val storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(
            GoogleCredentials.fromStream(
                FileInputStream("C:/Users/Vericoders/Documents/lawlinkup-27612faffcd1.json")
            )
        ).build().service
        val blobId = BlobId.of(bucketName, objectName)
        val blobInfo = BlobInfo.newBuilder(blobId).build()
        val precondition: Storage.BlobWriteOption = if (storage[bucketName, objectName] == null) {
            Storage.BlobWriteOption.doesNotExist()
        } else {
            Storage.BlobWriteOption.generationMatch(
                storage[bucketName, objectName].generation
            )
        }
        storage.createFrom(blobInfo, Paths.get(filePath), precondition)
        println(
            "File $filePath uploaded to bucket $bucketName as $objectName"
        )
    }
}