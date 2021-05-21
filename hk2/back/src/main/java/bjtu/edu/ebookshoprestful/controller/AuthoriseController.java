package bjtu.edu.ebookshoprestful.controller;

import bjtu.edu.ebookshoprestful.entity.Book;
import bjtu.edu.ebookshoprestful.entity.Role;
import bjtu.edu.ebookshoprestful.entity.UserInfo;
import bjtu.edu.ebookshoprestful.service.IRoleService;
import bjtu.edu.ebookshoprestful.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "用户授权接口")
public class AuthoriseController {
    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;

    @GetMapping("/users")
    @ApiOperation("获得用户及授权情况")
    public List<Object> getUsers(){
        List<Object> result=new ArrayList<>();
        List<UserInfo> userInfoList=userService.findAll();
        for (UserInfo u:userInfoList){
            Map<String ,Object> temp=new HashMap<>();
            temp.put("user",u.getUsername());
            List<String> temp2=new ArrayList<>();
            for (Role r:u.getRoles()){
                temp2.add(r.getRolename());
            }
            temp.put("role",temp2);
            result.add(temp);
        }
        return result;
    }

    @PutMapping("/users/assignment")
    @ApiOperation("授权用户")
    public List<Object> assignUsers(@RequestBody Map<String,Object> request){
        String username= (String) request.get("username");
        List<Integer> roles=(List<Integer>) request.get("roles");
        UserInfo user=userService.findByName(username);
        List<Role> roleList=new ArrayList<>();
        for(Integer id:roles){
            Role role1=roleService.findOne(id);
            roleList.add(role1);
        }
        user.setRoles(roleList);
        userService.update(user);
        return getUsers();
    }
}
