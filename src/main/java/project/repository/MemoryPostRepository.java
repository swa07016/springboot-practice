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
    
    public void generateDummyPosts() {
        Post post1 = new Post(1L, "title", "content", "tag", "https://html.com/wp-content/uploads/html-hpg-featured-new.png", "2021.04.01", "seonghoon");
    Post post2 = new Post(1L, "title", "content", "tag", "https://cdn.lynda.com/course/170427/170427-637363828865101045-16x9.jpg", "2021.04.01", "seongbin");
        this.save(post1);
        this.save(post2);
    }
    
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
    
    public Long update(Post post) {
        store.put(post.getId(), post);
        return post.getId();
    }
    
    public Long delete(Long id) {
        Post status = store.remove(id);
        if(status != null) return id;
        return -1L;
    }
}