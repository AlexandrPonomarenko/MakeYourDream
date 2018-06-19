package com.service.serviceImpl;

import com.dao.daoImpl.TestConfig;
import com.model.Role;
import com.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import start.WriteStartTest;
import test.JpaConfigureTest;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {JpaConfigureTest.class, TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleServiceImplTest {


    private static final Logger logger = LogManager.getLogger(RoleServiceImplTest.class);

    @Autowired
    public RoleService roleService;

    private Role role1;

    @Before
    public void setUp() throws Exception {
        role1 = new Role();
        role1.setNameRole("manager");
    }

    @After
    public void tearDown() throws Exception {
        role1 = null;
    }

    @Test
    public void findAllRolesTest() {
        logger.debug("hello");
        List<Role> roles = roleService.findAllRoles();
        int size = 3;
        assertEquals(size, roles.size());

        for (Role role: roles){
            logger.debug(role.getNameRole());
        }
        assertNotNull(roles);

    }

    @Test
    public void findByRoleNameTest() {
        Role role = roleService.findByRoleName("admin");
        String roleName = "admin";
        assertEquals(roleName, role.getNameRole());
        logger.debug(role.getNameRole());
    }

    @Test
    public void findByIdTest() {
        Role role = roleService.findById(67);
        logger.debug("role to string", role.toString());
        long id_role = 67;
        assertEquals(id_role, (long)role.getId_role());
    }

    @Test
    @Transactional
    @Rollback(true)
    public void saveRoleTest() {
        logger.warn("saveRoleTest");
        roleService.saveRole(role1);

    }

    @Test
    @Transactional
//    @Rollback(true)
    public void updateTest() {
        logger.warn("updateTest");
        role1.setNameRole("user2");
        roleService.update(role1);
    }

    @Test
    @Transactional
    public void deleteRoleTest(){
        logger.warn("deleteRoleTest");
        role1 = roleService.findById(68);
        assertNotNull(role1);
        roleService.delete(role1.getNameRole());
    }
}