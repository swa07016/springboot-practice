package project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import project.domain.Post;

public interface MongoPostRepository extends MongoRepository<Post, Long> {
    public Optional<Post> findById(Long id);    
    public List<Post> findAll();
}