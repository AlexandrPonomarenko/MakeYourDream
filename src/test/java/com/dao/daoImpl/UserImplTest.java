package com.dao.daoImpl;

import com.dao.RoleDAO;
import com.model.Role;
import com.model.User;
import com.service.RoleService;
import com.service.serviceImpl.RoleServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import test.JpaConfigureTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

//@ContextConfiguration(classes = {JpaConfigureTest.class, TestConfig.class})
@ContextConfiguration(locations = "classpath:db-config-test2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
class UserImplTest {

//    @Autowired
//    public UserImpl user;
//
    @Autowired
    public RoleDAO roleDAO;

    @Autowired
    public RoleService roleService;



    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Transactional
    @Rollback(true)
    void findByIdTest() {
    }

    @Test
    @Transactional
    @Rollback(true)
    void findByLoginTest() {
    }

    @Test
    @Transactional
//    @Rollback(true)
    void saveTest() {
        Role role = new Role();
        role.setNameRole("admin");

//        Role role1 = new Role();
//        role1.setNameRole("user");
//
//        Role role2 = new Role();
//        role2.setNameRole("none");

//        User user = new User("Alex", "Login",
//                "furriets@gmail.com", "111111111", LocalDate.now(), role);
//        role.getUsers().add(user);
        User user = new User();
        user.setPassword("111111111");
        user.setLogin("loginnnn");
        user.setName("alexds");
        user.setDate(LocalDate.now());
        user.setEmail("furriets@gmail.com");
        user.setRole(role);


//        User user1 = new User("Alex1", "Login1",
//                "furriets1@gmail.com", "222222222", LocalDate.now(), role1);
//        role1.getUsers().add(user1);
//
//        User user2 = new User("Alex2", "Login2",
//                "furriets2@gmail.com", "333333333", LocalDate.now(), role2);
//        role2.getUsers().add(user2);

        roleService.saveRole(role);
    }

    @Test
    @Transactional
    @Rollback(true)
    void deleteByLoginTest() {
    }

    @Test
    @Transactional
    @Rollback(true)
    void findAllUsersTest() {
    }

    @Test
    void initializeCollectionTest() {
    }
}