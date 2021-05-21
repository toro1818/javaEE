package bjtu.edu.ebookshoprestful.service;

import bjtu.edu.ebookshoprestful.entity.Role;
import bjtu.edu.ebookshoprestful.entity.UserInfo;
import bjtu.edu.ebookshoprestful.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

        @Autowired
        IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (s == null || "".equals(s))
        {
            throw new RuntimeException("用户不能为空");
        }
        System.out.println(s);

        UserInfo userInfo = userService.findByName(s);
//        UserInfo userInfo =new UserInfo();
//        userInfo.setId(1);
//        userInfo.setUsername("yc");
//        userInfo.setPassword("123456");

//        if (userInfo == null)
//        {
//            throw new RuntimeException("用户不存在");
//        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<Role> roleList=userInfo.getRoles();
        for (Role role:roleList){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRolename()));
            System.out.println("ROLE_"+role.getRolename());
        }
        return new org.springframework.security.core.userdetails.User(userInfo.getUsername(),"{noop}"+ userInfo.getPassword(),authorities);
    }


    public UserInfo getCurrentUser(String username) {
        //通过用户名获取用户
//        UserInfo userInfo = userRepository.findUserByUsername(username);
//
//        if (userInfo == null ) return null;
//
//
//        userInfo.setPassword(null);
//        return userInfo;
        return null;
    }
}
