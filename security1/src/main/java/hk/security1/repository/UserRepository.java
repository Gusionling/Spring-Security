package hk.security1.repository;

import hk.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//CRUD 함수를 JpaRepository가 들고있다.
//@Repository가 없어도 Ioc가 된다. 이유는 JpaRepository를 상송했기 때문이다
//UserRepository가 자동으로 Bean으로 등록이 된다.
public interface UserRepository extends JpaRepository<User, Long> {

    //findBy는 규칙이고 Username은 문법이다.
    //select * from user where username = ? 이런 sql문이 자동으로 만들어진다.
    public User findByUsername(String username);
}
