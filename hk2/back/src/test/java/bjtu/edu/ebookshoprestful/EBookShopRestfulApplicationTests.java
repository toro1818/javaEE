package bjtu.edu.ebookshoprestful;
import bjtu.edu.ebookshoprestful.entity.Role;
import bjtu.edu.ebookshoprestful.entity.UserInfo;
import bjtu.edu.ebookshoprestful.repository.RoleRepository;
import bjtu.edu.ebookshoprestful.repository.UsersRepository;
import bjtu.edu.ebookshoprestful.service.BookService;
import bjtu.edu.ebookshoprestful.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EBookShopRestfulApplicationTests {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    RoleRepository roleRepository;
    @Test
    void contextLoads() {
        System.out.println("初始化数据库");
    }

    @Test
    void addUser(){
        UserInfo userInfo =new UserInfo();
        userInfo.setUsername("test");
        userInfo.setPassword("123456");
        usersRepository.save(userInfo);
    }

    @Test
    void findByUsername(){
        UserInfo userInfo = usersRepository.findByUsername("admin");
        System.out.println(userInfo);
    }

    @Test
    void createRole(){
        Role role =new Role();
        role.setRolename("admin");
        Role role2 =new Role();
        role2.setRolename("normal");
        roleRepository.save(role);
        roleRepository.save(role2);
    }
    @Test
    void manytomany(){
        UserInfo user = usersRepository.findByUsername("test");
        user.setRoles(roleRepository.findAll());
        usersRepository.save(user);


    }

    @Test
    void getRoles(){
        UserInfo user = usersRepository.findByUsername("test");
        System.out.println(user.getRoles());
    }
    @Autowired
    IBookService bookService;
    @Test
    void getBooks(){

        System.out.println(bookService.findALL());
    }

}
