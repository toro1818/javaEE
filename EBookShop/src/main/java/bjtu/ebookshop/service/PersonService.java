package bjtu.ebookshop.service;


import bjtu.ebookshop.entity.Person;
import bjtu.ebookshop.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Resource
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findOne(Integer id) {
//        return personRespority.findOne(id);
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public Person insert(Person p) {
        return personRepository.save(p);
    }

    /**
     * 更新也是使用save()方法
     */
    @Override
    public Person update(Person p) {
        return personRepository.save(p);
    }

    @Override
    public void delete(Integer id) {
        personRepository.deleteById(id);
    }

}
