package project.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import project.domain.Post;

@Repository
public class MemoryPostRepository implements PostRepository {
    
    private static Map<Long, Post> store = new HashMap<>();
    private static long sequence = 0L;
    
    public Post save(Post post) { 
        post.setId(++sequence);
        store.put(post.getId(), post);
        return post;
    }

    public Optional<Post> findById(Long id) {
        
        return Optional.of(store.get(id));
    }
    
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }
    
}