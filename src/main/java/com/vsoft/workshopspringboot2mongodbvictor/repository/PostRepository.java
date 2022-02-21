package com.vsoft.workshopspringboot2mongodbvictor.repository;

import com.vsoft.workshopspringboot2mongodbvictor.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
