package project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import project.domain.Post;
import project.domain.PostDto;
import project.service.PostService;

@Controller
public class HomeController {
    
    @Autowired
    private PostService postService;
    
    @GetMapping("/")
    public String home(Model model) {
        List<Post> postList = postService.getAllPost();
        model.addAttribute("postList", postList);
        return "home.html";
    }
    
    @GetMapping("/register")
    public String getRegister() {
        return "register.html";
    }
    
    @GetMapping("/post/{postId}")
    public String getPost(@PathVariable(name = "postId") Long postId, Model model) {
        Optional<Post> post = postService.getById(postId);
        if(post.isPresent()) {
            model.addAttribute("post", post.get());
            return "post.html";
        }
        
        // 에러페이지 html 만들기
        return "존재하지 않는 게시물입니다..";
    }
    
    @PostMapping("/register")
    public String postRegister(PostDto postDto) {
        String title = postDto.getTitle();
        String content = postDto.getContent();
        String tag = postDto.getTag();
        String thumbnail = postDto.getThumbnail();
        
        Post post = new Post(title, content, tag, thumbnail); 
        
        post.setId(1L);
        
        SimpleDateFormat regdate = new SimpleDateFormat("yyyy.MM.dd");
        post.setRegdate(regdate.format(new Date()));
        
        post.setAuthor("seonghoon");
        
        postService.register(post);
        return "redirect:/";
    }
}