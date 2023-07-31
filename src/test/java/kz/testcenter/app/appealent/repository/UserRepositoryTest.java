package kz.testcenter.app.appealent.repository;

import kz.testcenter.app.appealent.model.publics.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindUserByLogin() {
        User user = userRepository.findUserByLogin("admin").orElse(new User());
        Assertions.assertEquals(user.getLogin(), "admin");
    }
}
