package com.vsoft.workshopspringboot2mongodbvictor.repository;

import com.vsoft.workshopspringboot2mongodbvictor.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
