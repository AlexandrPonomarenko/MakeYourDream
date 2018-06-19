package com.service.serviceImpl;

import com.dao.daoImpl.TestConfig;
import com.model.Role;
import com.model.User;
import com.service.RoleService;
import com.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import test.JpaConfigureTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {JpaConfigureTest.class, TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

    private static final Logger logger = LogManager.getLogger(UserServiceImplTest.class);

    @Autowired
    public UserService userService;

    @Autowired
    private RoleService roleService;

    public User user;
    public Role role;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findById() {
        logger.warn("findById");
        user = userService.findById(77);
        assertEquals(77, (int)user.getId());

        logger.warn(user.toString());
    }

    @Test
    public void findByLogin() {
        logger.warn("findById");
        user = userService.findByLogin("Login3");
        assertEquals("Login3", user.getLogin ());

        logger.warn(user.toString());
    }

    @Test
    @Transactional
    public void saveUser() {
        logger.warn("saveUser");
        role = roleService.findById(68);
        logger.warn("-------- " + role.toString());
        assertEquals(68, (int)role.getId_role());

                 user = new User("Alex007", "Login007",
                "furriets007@gmail.com", "32233223", LocalDate.now(), role);
        user.setRole(role);
        role.getUsers().add(user);
        roleService.update(role);

        user = userService.findByLogin("Login007");
        logger.warn("-------- " + user.toString());
        assertEquals("Alex007", user.getName());
    }

    @Test
    @Transactional
    public void updateUser() {
        logger.warn("updateUser");
        user = userService.findByLogin("Login1");
        assertNotNull(user);
        user.setName("TOR");
        userService.updateUser(user);
        User user1 = userService.findByLogin("Login1");
        assertEquals("TOR", user1.getName());
    }

    @Test
    @Transactional
    public void deleteUser() {
        logger.warn("deleteUser");

        List<User> users = userService.findAllUsers();
        assertEquals(5, users.size());

        userService.deleteUser(users.get(2).getLogin());

        users = userService.findAllUsers();
        assertEquals(4, users.size());
    }

    @Test
    public void findAllUsers() {
        logger.warn("findAllUsers");
        List<User> users = userService.findAllUsers();
        for(User user: users){
            logger.warn("-----" + user.toString());
        }
    }

    @Test
    public void isUserLoginUnique() {
        user = userService.findByLogin("Login1");
        assertTrue(userService.isUserLoginUnique(user.getId(), user.getLogin()));
    }
}