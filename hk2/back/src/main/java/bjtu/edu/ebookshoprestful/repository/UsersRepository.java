package bjtu.edu.ebookshoprestful.repository;

import bjtu.edu.ebookshoprestful.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserInfo,Integer> {
    UserInfo findByUsername(String name);
}
