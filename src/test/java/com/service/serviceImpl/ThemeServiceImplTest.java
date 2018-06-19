package com.service.serviceImpl;

import com.dao.daoImpl.TestConfig;
import com.model.Theme;
import com.model.User;
import com.service.ThemeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class ThemeServiceImplTest {

    private static final Logger logger = LogManager.getLogger(ThemeServiceImplTest.class);

    @Autowired
    public ThemeService themeService;

    @Test
    public void findAllThemes() {
        logger.warn("findAllUsers");
        List<Theme> themes = themeService.findAllThemes();
        for(Theme theme: themes){
            logger.warn("-----" + theme.toString());
        }
        assertEquals(5, themes.size());
    }

//    @Test
//    public void findByThemeHead() {
//        logger.warn("findByThemeHead");
//        Theme theme = themeService.findByThemeHead("SuperProject");
//        assertEquals("SuperProject", theme.getHead());
//    }

    @Test
    public void findById() {
        logger.warn("findById");
        Theme theme = themeService.findById(7);
        assertEquals(7, (int)theme.getId());
    }

    @Test
    @Transactional
    public void saveTheme() {
        Theme theme = new Theme();
        theme.setDescription("tryqweafzCZXCZXC");
        theme.setDate(LocalDate.now());
        theme.setEnd_date(LocalDate.now().plusMonths(1));
        theme.setHead("sadasda");
        themeService.saveTheme(theme);
    }
}