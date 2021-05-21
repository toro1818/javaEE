package bjtu.edu.ebookshoprestful.service;

import bjtu.edu.ebookshoprestful.entity.Role;
import bjtu.edu.ebookshoprestful.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findALL() {
        return null;
    }

    @Override
    public Role findOne(Integer id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role insert(Role b) {
        return null;
    }

    @Override
    public Role update(Role b) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
