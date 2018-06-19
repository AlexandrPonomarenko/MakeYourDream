package com.service.serviceImpl;

import com.dao.daoImpl.TestConfig;
import com.model.Video;
import com.service.VideoService;
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
public class VideoServiceImplTest {
    private static final Logger logger = LogManager.getLogger(VideoServiceImplTest.class);

    @Autowired
    VideoService videoService;

    @Test
    public void findById() {
        logger.warn("findById");
        Video video = videoService.findById(2);
        assertEquals(2, (int)video.getId());
    }
}