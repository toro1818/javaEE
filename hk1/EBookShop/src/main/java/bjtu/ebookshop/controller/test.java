package bjtu.ebookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {
    @GetMapping("/test")
    public String index(){
        return "login.html";
    }
}
