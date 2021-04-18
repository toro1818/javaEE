package bjtu.ebookshop.repository;

import bjtu.ebookshop.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
    public UserInfo findByUsername(String username);
}
