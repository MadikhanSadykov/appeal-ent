package kz.testcenter.app.appealent.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testGetRoleNameByUserId() {
        String roleName = userDAO.getRoleNameByUserId(750);
        Assertions.assertEquals(roleName, "ROLE_COMMISSION_MEMBER");
    }

}
