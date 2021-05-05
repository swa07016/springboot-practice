package project.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.lang.Iterable;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import project.domain.post.Post;
import project.repository.MysqlPostRepository;

@Service
@Transactional
public class PostService {
    
    @Autowired
    private MysqlPostRepository postRepository;

    // public PostService(PostRepository postRepository) {
    //     this.postRepository = postRepository;
    //     // this.postRepository.generateDummyPosts();
    // }
    
    public PostService(MysqlPostRepository _postRepository) {
        this.postRepository = _postRepository;
    }
    
    public Long register(Post post) {
        postRepository.save(post);
        return post.getId();
    }
    
    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }
    
    public List<Post> getAllPost() {
        // postRepository가 Iterable<Post>를 리턴?
        List<Post> postList = postRepository.findAll();
        // postRepository.findAll().forEach(postList::add);    
        return postList;
    }
    
    public Long updatePost(Post post) {
        // implements
        // save메소드 update로 변경하기
        postRepository.save(post);
        return post.getId();
    }
    
    public Long deletePost(Long id) {
        // null 예외처리하기
        postRepository.deleteById(id);
        return id;
    }
}