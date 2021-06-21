package bjtu.edu.gateway_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hystrixController {
    @RequestMapping(value = "/downgrade",produces = "text/html;charset=UTF-8")
    public String downgrade(){
        return "<html><body><div style='width:800px;margin:auto;text-align:center;font-size:24px'>服务器忙，请稍后重试</div></body></html>";
    }
}
