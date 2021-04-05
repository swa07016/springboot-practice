package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.domain.Post;

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
    
    // @PostMapping("/register")
    // @ResponseBody
    // public Post postRegister(@RequestParam(value="id") Long id) {
    //     //test
    //     Post post = new Post(id, "3", "1", "2", "3", "4");
    //     return post;
    // }
}