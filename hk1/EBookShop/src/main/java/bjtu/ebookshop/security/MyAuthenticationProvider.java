package bjtu.ebookshop.security;

import bjtu.ebookshop.entity.UserInfo;
import bjtu.ebookshop.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;


@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserInfoService userInfoService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String username = authentication.getName();
       String password = (String)authentication.getCredentials();
       UserInfo userInfo = (UserInfo)userInfoService.loadUserByUsername(username);


       if (userInfo == null){
           throw new BadCredentialsException("用户名不存在");
       }

       if (!userInfo.getPassword().equals(password)){
           throw new BadCredentialsException("密码不正确");
       }

        //session添加useranme
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute("user",username);


        Collection< ? extends GrantedAuthority> authorities = userInfo.getAuthorities();

        return new UsernamePasswordAuthenticationToken(userInfo,password,authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
