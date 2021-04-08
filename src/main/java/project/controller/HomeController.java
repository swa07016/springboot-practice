package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import project.domain.PostDto;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model) {
        return "home.html";
    }
    
    @GetMapping("/register")
    public String getRegister() {
        return "register.html";
    }
    
    @PostMapping("/register")
    @ResponseBody
    public PostDto postRegister(PostDto postDto) {
        //test 
        System.out.println(postDto);
        System.out.println(postDto.getTitle());
        System.out.println(postDto.getContent());
        System.out.println(postDto.getTag());
        System.out.println(postDto.getThumbnail());
        return postDto;
    }
}