package bjtu.ebookshop.repository;

import bjtu.ebookshop.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Integer> {
}
