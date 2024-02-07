package com.server.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.server.models.PublicationModel;
import com.server.models.UserModel;
import com.server.repos.PublicationRepo;
import com.server.repos.UserRepo;
import com.server.service.FileUploadService;

import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Controller
public class RouteController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PublicationRepo publicationRepo;

    @PostMapping("/register")
    public UserModel registerMethod(@RequestBody UserModel userData) {
        try {

            UserModel user = userRepo.save(userData);
            return user;

        } catch (Exception e) {

            return null;
        }
    }

    @PostMapping("/login")
    public UserModel loginMethod(@RequestBody UserModel userData) {
        try {
            UserModel user = userRepo.findByEmail(userData.getEmail());

            if (user.getPassword().equals(userData.getPassword())) {

                return user;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private final FileUploadService fileUploadService;

    public RouteController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    private final String uploadPath = "C:\\Users\\harsh\\OneDrive\\Desktop\\research_publication_springboot\\client\\public\\pdfs";

    @PostMapping("/new-publication")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, 
                                        @RequestParam("title") String title,
                                        @RequestParam("description") String description,
                                        @RequestParam("bannerImg") String bannerImg,
                                        @RequestParam("domain") String domain,
                                        @RequestParam("keywords") List<String> keywords,
                                        @RequestParam("author") String author,
                                        @RequestParam("authorId") String authorId,
                                        @RequestParam("publishedDate") String publishedDate) throws IOException {
        
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadPath, uniqueFileName);
        Files.write(filePath, file.getBytes());

        PublicationModel publication = new PublicationModel();
        publication.setTitle(title);
        publication.setDescription(description);
        publication.setBannerImg(bannerImg);
        publication.setDomain(domain);
        publication.setKeywords(keywords);
        publication.setAuthor(author);
        publication.setAuthorId(authorId);
        publication.setPublishedDate(publishedDate);
        publication.setPdfFileName(uniqueFileName);
        publication.setStatus("pending");

        publicationRepo.save(publication);

        return ResponseEntity.ok("File uploaded successfully!");
    }

    @GetMapping("/fetch-publications")
    public List<PublicationModel> getPublications() {

        List<PublicationModel> publications = publicationRepo.findAll();
        return publications;
    }
    
    @GetMapping("/fetch-publication/{id}")
    public PublicationModel getPublication(@PathVariable("id")  String id) {

        PublicationModel publication = publicationRepo.findById(id).get();
        return publication;
    }

    @PostMapping("/approve-publication/{id}")
    public PublicationModel postMethodName(@PathVariable("id")  String id, @RequestBody PublicationModel evaluator) {
        PublicationModel publication = publicationRepo.findById(id).get();
        
        publication.setStatus("accepted");
        publication.setEvaluator(evaluator.getEvaluator());
        publication.setEvaluatorId(evaluator.getEvaluatorId());
        publication.setEvaluationDate(evaluator.getEvaluationDate());
        publication.setEvaluationNote(evaluator.getEvaluationNote());

        publicationRepo.save(publication);

        return null;
    }
    


    @GetMapping("/fetch-users")
    public List<UserModel> getUsers() {

        List<UserModel> users = userRepo.findAll();
        return users;
    }


    
}
