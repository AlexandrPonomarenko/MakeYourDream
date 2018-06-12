package com.dao;

import com.dao.daoImpl.TestConfig;
import com.model.Role;
import com.model.User;
import com.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.JpaConfigureTest;

import java.time.LocalDate;

import static org.junit.Assert.*;
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {JpaConfigureTest.class, TestConfig.class})
//@ContextConfiguration(locations = "classpath:db-config-test2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleDAOTest {


    @Autowired
    public RoleDAO roleDAO;

    @Autowired
//    @Qualifier("roleService")
    public RoleService roleService;


    @Test
    public void findAllRoles() {
    }

    @Test
    public void findByRoleName() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void saveTest() {
//        Role role = new Role();
//        role.setNameRole("admin");
//
//        Role role1 = new Role();
//        role1.setNameRole("user");
//
//        Role role2 = new Role();
//        role2.setNameRole("none");
//
//        User user = new User("Alex", "Login",
//                "furriets@gmail.com", "111111111", LocalDate.now(), role);
//        role.getUsers().add(user);
////        User user = new User();
////        user.setPassword("111111111");
////        user.setLogin("loginnnn");
////        user.setName("alexds");
////        user.setDate(LocalDate.now());
////        user.setEmail("furriets@gmail.com");
////        user.setRole(role);
////        role.getUsers().add(user);
//
//
//        User user1 = new User("Alex1", "Login1",
//                "furriets1@gmail.com", "222222222", LocalDate.now(), role1);
//        role1.getUsers().add(user1);
//
//        User user2 = new User("Alex2", "Login2",
//                "furriets2@gmail.com", "333333333", LocalDate.now(), role2);
//        role2.getUsers().add(user2);
//
//        roleService.saveRole(role);
    }
}