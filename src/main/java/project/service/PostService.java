package project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import project.domain.Post;
import project.repository.PostRepository;

@Service
public class PostService {
    
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
        this.postRepository.generateDummyPosts();
    }
    
    public Long register(Post post) {
        postRepository.save(post);
        return post.getId();
    }
    
    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }
    
    public List<Post> getAllPost() {

        List<Post> postList = postRepository.findAll();
        return postList;
    }
    
    public Long updatePost(Post post) {
        // implements
        Long id = postRepository.update(post);
        return id;
    }
    
    public Long deletePost(Long id) {
        Long status = postRepository.delete(id);
        if(status == -1L) return -1L;
        return id;
    }
}