package bjtu.edu.authorization_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class testController {
    @GetMapping("/user")
    public Principal getCurrentUser(Principal principal) {
        return principal;
    }
}
