package bjtu.edu.ebookshoprestful.controller;


import bjtu.edu.ebookshoprestful.entity.Role;
import bjtu.edu.ebookshoprestful.entity.UserInfo;
import bjtu.edu.ebookshoprestful.service.IUserService;
import bjtu.edu.ebookshoprestful.service.UserDetailServiceImpl;
import bjtu.edu.ebookshoprestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
@Controller
//@CrossOrigin
public class LoginController {
//    @Autowired
//    private IUserService userService;

//    @PostMapping("/api/login")
//    public Map<String,Object> login(@RequestBody Map<String,Object> user)
//    {
//        // 获得用户名密码
//        String username= (String) user.get("username");
//        String password= (String) user.get("password");
//        String password2=userService.findByName(username).getPassword();
//        Map<String,Object> map=new HashMap<>();
//        if(username.equals("admin")&&password.equals(password2)){
//            map.put("code","200");
//            map.put("msg","登录成功");
//        }else{
//            map.put("code","-1");
//            map.put("msg","账号或密码错误");
//        }
//        return map;
//    }

    @Autowired
    UserDetailServiceImpl userDetailService;

    @GetMapping("/data")
    private String data()
    {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userDetailService.getCurrentUser(username);
        return "This is data.";
    }

    @GetMapping("/1")
    private String test(){

        return "index.html";
    }
}
