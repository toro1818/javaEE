package bjtu.edu.ebookshoprestful.service;

import bjtu.edu.ebookshoprestful.entity.Book;
import bjtu.edu.ebookshoprestful.entity.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findALL();

    Role findOne(Integer id);

    Role insert(Role b);

    Role update(Role b);

    void delete(Integer id);
}
