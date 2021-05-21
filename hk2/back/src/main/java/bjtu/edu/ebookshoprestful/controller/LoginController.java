package bjtu.edu.ebookshoprestful.controller;


import bjtu.edu.ebookshoprestful.entity.Role;
import bjtu.edu.ebookshoprestful.entity.UserInfo;
import bjtu.edu.ebookshoprestful.service.IRoleService;
import bjtu.edu.ebookshoprestful.service.IUserService;
import bjtu.edu.ebookshoprestful.service.UserDetailServiceImpl;
import bjtu.edu.ebookshoprestful.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "登录注册接口")
//@Controller
//@CrossOrigin
public class LoginController {


    @Autowired
    private IUserService userService;

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    private IRoleService roleService;

    @ApiOperation("测试使用，无用")
    @GetMapping("/data")
    private String data()
    {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userDetailService.getCurrentUser(username);
        return "This is data.";
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public Map<String,Object> register(@RequestBody Map<String,Object> user)
    {
        // 获得用户名密码
        String username= (String) user.get("username");
        String password= (String) user.get("password");
        String password2=(String) user.get("password2");
        Map<String,Object> map=new HashMap<>();
        boolean isRepeat=userService.findByName(username)==null ? false:true;
//        System.out.println(flag);
        if(!isRepeat&&password.equals(password2)){
            UserInfo userInfo=new UserInfo();
            userInfo.setUsername(username);
            userInfo.setPassword(password);
            List<Role> roleList=new ArrayList<>();
            roleList.add(roleService.findOne(2));
            userInfo.setRoles(roleList);
            userService.insert(userInfo);
            map.put("code","200");
            map.put("msg","注册成功");
        }else if (isRepeat){
            map.put("code","-1");
            map.put("msg","用户名已注册");
        }else {
            map.put("code","-1");
            map.put("msg","两次密码不一致");
        }
        return map;
    }
}
