package com.vsoft.workshopspringboot2mongodbvictor.repository;

import com.vsoft.workshopspringboot2mongodbvictor.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByTitleContainingIgnoreCase(String text);
}
