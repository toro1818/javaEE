package bjtu.ebookshop.service;


import bjtu.ebookshop.entity.Person;

import java.util.List;

public interface IPersonService {

    List<Person> findAll();

    Person findOne(Integer id);

    Person insert(Person p);

    Person update(Person p);

    void delete(Integer id);

}
