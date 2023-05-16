package be.thomasmore.toydoc.service;
import be.thomasmore.toydoc.model.AppUser;
import be.thomasmore.toydoc.repositories.AppUserRepository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.SessionCookieOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Service
@PropertySource("classpath:google.properties")
public class GoogleService {
    private Logger logger = Logger.getLogger(GoogleService.class.getName());
    @Autowired
    private AppUserRepository appUserRepository;
    @Value("${firebase.toydoc.json}")
    private String jsonFile;
    @Value("${firebase.bucket.images}")
    private String imageBucket;


    public void uploadFile(MultipartFile file, Principal principal) throws IOException {

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
        // Generate a URL for the file
        String imageUrl = blob.signUrl(1, TimeUnit.HOURS).toString();

        // Close the input stream
        inputStream.close();
        // Get the logged-in user's username
        String username = principal.getName();
        // Get the AppUser object from the repository based on the username
        AppUser appUser = appUserRepository.findByUsername(username);
        appUser.setImageUrl(imageUrl);
        appUserRepository.save(appUser);
        logger.info("File uploaded successfully." + imageUrl);
    }
//    public void uploadFile(MultipartFile file) throws IOException, FirebaseAuthException {
//        // Retrieve the authenticated user's username
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // Get the authentication object
//        String username = authentication.getName(); // Get the username
//
//        // Retrieve the AppUser object from the repository based on the username
//        AppUser appUser = appUserRepository.findByUsername(username);
//
//        // Initialize Firebase Admin SDK
//        FirebaseApp firebaseApp = FirebaseApp.initializeApp();  // Initialize the default app
//        String uid = appUser.getId().toString(); // Replace with the user ID associated with the file access
//        String fileId = file.getOriginalFilename(); // Replace with the specific file ID or resource name
//        long expiresInMinutes = 60; // Set the expiration time of the token in minutes
//        long expiresInMilliSeconds = expiresInMinutes * 60 * 1000; // Set the expiration time of the token in seconds
//
//        SessionCookieOptions cookieOptions = SessionCookieOptions.builder() // Start session cookie builder
//                .setExpiresIn(expiresInMilliSeconds) // Set the token expiration time
//                .build();             // Build the session cookie options
//
//        String customToken = FirebaseAuth.getInstance(firebaseApp)  // Get the Firebase Auth instance for the app
//                .createSessionCookie(uid, cookieOptions); // Create the session cookie
//
//
//        // Create a storage client
//        StorageOptions options = StorageOptions.newBuilder()    // Start storage client builder
//                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(jsonFile)))    // Set the Firebase credentials
//                .build();   // Build the storage client
//        Storage storage = options.getService(); // Get the storage client service
//
//        // Get the input stream from the uploaded file
//        InputStream inputStream = file.getInputStream();    // Get the input stream from the uploaded file
//
//        // Define the file name and destination path
//        String fileName = file.getOriginalFilename();   // Get the original file name
//        String destinationPath = "uploads/" + fileName; // Define the destination path
//        String encodedPath = URLEncoder.encode(destinationPath, StandardCharsets.UTF_8);    // Encode the destination path
//
//        // Define the blob info
//        BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of(imageBucket, destinationPath))    // Start blob info builder
//                .setContentType(file.getContentType())  // Set the content type
//                .build();   // Build the blob info
//
//        // Upload the file to Firebase Storage
//        Blob blob = storage.create(blobInfo, inputStream);  // Upload the file to Firebase Storage
//        logger.info("blob medialink: " + blob.getMediaLink() + "\n" + "blobinfo medialink: " + blobInfo.getMediaLink());    // Log the media link of the blob
//
//        // Get the Blob object representing the file
//        Blob blobObject = storage.get(imageBucket, fileName);
//
//        // Attach the custom token to the file URL
//        String imageUrl = String.format("https://firebasestorage.googleapis.com/v0/b/%s/o/%s?alt=media&token=%s",
//                imageBucket, encodedPath, customToken); // Construct the image URL
//
//        // Update the imageUrl attribute of the retrieved AppUser
//        appUser.setImageUrl(imageUrl);
//
//        // Save the updated user object in your database
//        appUserRepository.save(appUser);
//
//        // Close the input stream
//        inputStream.close();
//    }
}
