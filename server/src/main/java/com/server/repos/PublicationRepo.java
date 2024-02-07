package com.server.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.server.models.PublicationModel;

public interface PublicationRepo extends MongoRepository<PublicationModel, String>{
    
}
