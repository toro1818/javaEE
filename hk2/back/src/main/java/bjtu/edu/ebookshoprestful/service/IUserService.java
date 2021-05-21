package bjtu.edu.ebookshoprestful.service;

import bjtu.edu.ebookshoprestful.entity.UserInfo;

import java.util.List;

public interface IUserService {
    List<UserInfo> findAll();

    UserInfo findOne(Integer id);

    UserInfo findByName(String name);

    UserInfo insert(UserInfo userInfo);

    UserInfo update(UserInfo userInfo);

    void delete(Integer id);
}
