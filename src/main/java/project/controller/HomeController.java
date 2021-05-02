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

import project.domain.post.Post;
import project.domain.post.PostDto;
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
    
    @PostMapping("/post/register")
    public String postRegister(PostDto postDto) {        
        
        SimpleDateFormat _regdate = new SimpleDateFormat("yyyy.MM.dd");
        Post post = new Post
            .Builder(1L)
            .title(postDto.getTitle())
            .content(postDto.getContent())
            .tag(postDto.getTag())
            .thumbnail(postDto.getThumbnail())
            .regdate(_regdate.format(new Date()))
            .author("seonghoon")
            .build();
        
        postService.register(post);
        return "redirect:/";
    }
    
    @GetMapping("/post/{postId}")
    public String getPost(@PathVariable(name = "postId") Long postId, Model model) {
        Optional<Post> post = postService.getById(postId);
        if(post.isPresent()) {
            model.addAttribute("post", post.get());
            return "post.html";
        }
    
        return "notfound.html";
    }
    
    @PostMapping("/post/preview")
    public String postPreview(PostDto postDto, Model model) {
        SimpleDateFormat _regdate = new SimpleDateFormat("yyyy.MM.dd");
        Post post = new Post
            .Builder(1L)
            .title(postDto.getTitle())
            .content(postDto.getContent())
            .tag(postDto.getTag())
            .thumbnail(postDto.getThumbnail())
            .regdate(_regdate.format(new Date()))
            .author("seonghoon")
            .build();
        
        model.addAttribute("post", post);
        return "preview.html";
    }
    
    
    //update
    @GetMapping("/post/update/{postId}")
    public String getUpdatePost(@PathVariable(name = "postId") Long postId, Model model) {
        Optional<Post> post = postService.getById(postId);
        if(post.isPresent()) {
            model.addAttribute("post", post.get());
            return "update.html";
        }
        
        //
        return "권한이 없습니다..";
    }
    
    @PostMapping("/post/update/{postId}")
    public String postUpdatePost(@PathVariable(name = "postId") Long postId, PostDto postDto) {
        Optional<Post> optPost = postService.getById(postId);
        if(optPost.isPresent()) {
            Post post = optPost.get();
            post.setTitle(postDto.getTitle());
            post.setContent(postDto.getContent());
            postService.updatePost(post);
            return "redirect:/post/{postId}";
        }
        return "failed";
    }
    
    @PostMapping("/post/delete/{postId}")
    public String postDeletePost(@PathVariable(name = "postId") Long postId) {
        Long status = postService.deletePost(postId);
        if(status == -1L) return "errorpage";
        return "redirect:/";
    }
    
}