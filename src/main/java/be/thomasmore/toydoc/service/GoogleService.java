package be.thomasmore.toydoc.service;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
@PropertySource("classpath:google.properties")
public class GoogleService {
    @Autowired
    private ResourceLoader resourceLoader;
    @Value("${firebase.toydoc.json}")
    private String jsonFile;
    @Value("${firebase.bucket.images}")
    private String imageBucket;

    public String toFirebase(File file, String fileName) throws IOException {
        BlobId blobId = BlobId.of(imageBucket, fileName);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        Resource resource = resourceLoader.getResource("classpath:" + jsonFile);
        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(resource.getFile()));
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
        return String.format("https://firebasestorage.googleapis.com/v0/b/tm-speelgoeddokter.appspot.com/o/%s?alt=media", URLEncoder.encode(fileName, StandardCharsets.UTF_8));
    }

    public void uploadFile(MultipartFile file) throws IOException {

        // Create a storage client
        StorageOptions options = StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(jsonFile)))
                .build();
        Storage storage = options.getService();

        // Get the input stream from the uploaded file
        InputStream inputStream = file.getInputStream();

        // Define the file name and destination path
        String fileName = file.getOriginalFilename();
        String destinationPath = "uploads/" + fileName;

        // Define the blob info
        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(imageBucket, destinationPath))
                .setContentType(file.getContentType())
                .build();

        // Upload the file to Firebase Storage
        Blob blob = storage.create(blobInfo, inputStream);

        // Close the input stream
        inputStream.close();
    }



}
