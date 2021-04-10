package project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        System.out.print(postList.size());
        return "home.html";
    }
    
    @GetMapping("/register")
    public String getRegister() {
        return "register.html";
    }
    
    @PostMapping("/register")
    @ResponseBody
    public Post postRegister(PostDto postDto) {
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
        return post;
    }
}