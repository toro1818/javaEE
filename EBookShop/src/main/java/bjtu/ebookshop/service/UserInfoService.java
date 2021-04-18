package bjtu.ebookshop.service;

import bjtu.ebookshop.entity.UserInfo;
import bjtu.ebookshop.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    UserInfoRepository userInfoRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findByUsername(s);

        if (userInfo == null) return null;
        else return userInfo;
    }
}
