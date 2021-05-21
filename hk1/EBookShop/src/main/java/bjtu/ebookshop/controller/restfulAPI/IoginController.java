package bjtu.ebookshop.controller.restfulAPI;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class IoginController {
    @PostMapping("/api/login")
    public Map<String,Object> login(@RequestBody Map<String,Object> user)
    {
        // 直接将json信息打印出来
        System.out.println(user.get("username"));
        Map<String,Object> map=new HashMap<>();
        String username= (String) user.get("username");
        String password= (String) user.get("password");
        if(username.equals("admin")&&password.equals("123456")){
            map.put("code","200");
            map.put("msg","账号或密码正确");
        }else{
            map.put("msg","账号或密码正确");
            map.put("msg","账号或密码错误");
        }
        return map;
    }
//    public String getByJSON(@RequestBody JSONObject jsonParam) {
//
//        // 直接将json信息打印出来
//        System.out.println(jsonParam.toJSONString());
//        // 将获取的json数据封装一层，然后在给返回
//        JSONObject result = new JSONObject();
//        result.put("msg", "ok");
//        result.put("method", "json");
//        result.put("data", jsonParam);
//
//        return result.toJSONString();
//    }

}
