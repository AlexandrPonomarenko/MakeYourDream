package com.service.serviceImpl;

import com.dao.daoImpl.TestConfig;
import com.model.Like;
import com.model.Money;
import com.service.LikeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.JpaConfigureTest;

import static org.junit.Assert.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {JpaConfigureTest.class, TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LikeServiceImplTest {

    private static final Logger logger = LogManager.getLogger(LikeServiceImplTest.class);

    @Autowired
    LikeService likeService;

    @Test
    public void findById() {
        logger.warn("findById");
        Like like = likeService.findById(4);
        assertEquals(4, (int)like.getId());
    }
}