package bjtu.edu.ebookshoprestful.service;

import bjtu.edu.ebookshoprestful.entity.UserInfo;
import bjtu.edu.ebookshoprestful.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserInfo> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public UserInfo findOne(Integer id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public UserInfo findByName(String name) {
        return usersRepository.findByUsername(name);
    }

    @Override
    public UserInfo insert(UserInfo userInfo) {
        return usersRepository.save(userInfo);
    }

    @Override
    public UserInfo update(UserInfo userInfo) {
        return usersRepository.save(userInfo);
    }

    @Override
    public void delete(Integer id) {
        usersRepository.deleteById(id);
    }
}
