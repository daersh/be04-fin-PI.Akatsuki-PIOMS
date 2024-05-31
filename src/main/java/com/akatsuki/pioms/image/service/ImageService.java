package com.akatsuki.pioms.image.service;

import com.akatsuki.pioms.image.aggregate.Image;
import com.akatsuki.pioms.image.repository.ImageRepository;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Service
public class
ImageService {
    @Value("${spring.cloud.gcp.storage.bucket}") // application.yml에 써둔 bucket 이름
    private  String bucketName;
    @Value("${spring.cloud.gcp.storage.project-id}")
    private  String projectId;
    @Value("${spring.cloud.gcp.storage.credentials.location}")
    private String credentialsLocation;
    ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public boolean uploadImage(int productCode, MultipartFile file) {

        try {
            ClassPathResource resource = new ClassPathResource(credentialsLocation);
            GoogleCredentials credentials = GoogleCredentials.fromStream(resource.getInputStream());

            Storage storage = StorageOptions.newBuilder()
                    .setCredentials(credentials)
                    .setProjectId(projectId)
                    .build()
                    .getService();

            String fileName = UUID.randomUUID().toString().substring(0, 6);

            BlobId blobId = BlobId.of(bucketName, fileName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();

            byte[] bytes = file.getBytes();
            Blob blob = storage.create(blobInfo, bytes);
            Image image = imageRepository.save(new Image(blob.getMediaLink(), productCode));
        }catch (IOException e){
            return false;
        }
        return true;
    }

    public Image getImageByProductCode(int productCode){
        List<Image> images =  imageRepository.findByProductCode(productCode);
        if (images == null || images.isEmpty() )
            return null;
        return images.get(0);
    }

}
