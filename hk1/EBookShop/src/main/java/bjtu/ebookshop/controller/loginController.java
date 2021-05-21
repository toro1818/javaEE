package bjtu.ebookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {

    @RequestMapping("/login")
    public String tologinpage(){
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, path= "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session){
        if(username.equals("admin")&&password.equals("123456")){
            System.out.println(123);
//            session.setAttribute("loginUser",username);
            return "redirect:/index";
        }else{

            return "login";
        }
    }
//
//    @RequestMapping(value = "/user/logout")
//    public String logout(HttpSession session){
////        session.removeAttribute("loginUser");
//        session.invalidate();
//        return "redirect:/login";
//    }
}
