package com.service.serviceImpl;

import com.dao.daoImpl.TestConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.JpaConfigureTest;

import static org.junit.Assert.*;
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {JpaConfigureTest.class, TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CardServiceImplTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllCards() {
    }

    @Test
    public void findByCardBankName() {
    }

    @Test
    public void findByCardNumber() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void deleteByIdNumberCard() {
    }

    @Test
    public void updateCard() {
    }
}