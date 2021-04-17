package project.repository;

import java.util.List;
import java.util.Optional;

import project.domain.Post;

public interface PostRepository {
    
    void generateDummyPosts();
    Post save(Post post);
    Optional<Post> findById(Long id);    
    List<Post> findAll();
    Long updatePost(Post post);
}