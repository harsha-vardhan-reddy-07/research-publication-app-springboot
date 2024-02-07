package com.server.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.models.PublicationModel;
import com.server.repos.PublicationRepo;

@Service
public class FileUploadService {

    @Autowired
    PublicationRepo publicationRepo;

    private final String uploadPath = "C:\\Users\\harsh\\OneDrive\\Desktop\\research_publication_springboot\\client\\src\\pdfs";

    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxFileSize;

    public PublicationModel saveFileAndPublication(MultipartFile file) throws FileUploadException, JsonMappingException, JsonProcessingException {
        if (file.isEmpty()) {
            throw new FileUploadException("File is empty");
        }
        if(file.getSize() > Long.parseLong(maxFileSize)) {
            throw new FileUploadException("File size exceeds the limit");
        }

        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        try {
            Files.copy(file.getInputStream(), Paths.get(uploadPath, uniqueFileName));
        } catch (IOException e) {
            throw new FileUploadException("Error saving file: " + e.getMessage());
        }

        // publication.setPdfFileName(uniqueFileName);

        // Save publication data
        // publicationRepo.save(publication);

        return null;
    }
}
