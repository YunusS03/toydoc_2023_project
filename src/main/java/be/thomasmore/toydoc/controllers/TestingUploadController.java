//package be.thomasmore.toydoc.controllers;
//import be.thomasmore.toydoc.model.AppUser;
//import be.thomasmore.toydoc.repositories.AppUserRepository;
//import com.google.cloud.storage.BlobId;
//import com.google.cloud.storage.BlobInfo;
//import com.google.cloud.storage.Storage;
//import com.google.cloud.storage.StorageOptions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.IOException;
//import java.time.Duration;
//import java.time.Instant;
//import java.util.UUID;
//
//@Controller
//@RequestMapping("user")
//public class TestingUploadController {
//
//    @Value("${firebase.bucketName}")
//    private String bucketName;
//    @Autowired
//    private AppUserRepository appUserRepository;
//
//    private Storage storage = StorageOptions.getDefaultInstance().getService();
//
//    @PostMapping("/upload")
//    public String uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
//        // Generate a unique filename for the image
//        String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//
//        // Upload the image file to Firebase Storage
//        BlobId blobId = BlobId.of(bucketName, filename);
//        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType(file.getContentType()).build();
//        storage.create(blobInfo, file.getBytes());
//
//        // Get the download URL of the uploaded image
//        String imageUrl = String.format("https://storage.googleapis.com/%s/%s?Expires=%d",
//                bucketName, filename, Instant.now().plus(Duration.ofHours(1)).getEpochSecond());
//
//        // Update the logged-in user's imageUrl attribute
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        AppUser appUser = (AppUser) authentication.getPrincipal();
//        appUser.setImageUrl(imageUrl);
//
//        // Save the updated user object in your database
//        appUserRepository.save(appUser);
//
//        return imageUrl;
//    }
//}
//
