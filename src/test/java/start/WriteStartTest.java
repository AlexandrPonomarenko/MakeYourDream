package start;

import com.dao.RoleDAO;
import com.dao.UserDAO;
import com.dao.daoImpl.RoleImpl;
import com.dao.daoImpl.TestConfig;
import com.model.*;
import com.service.RoleService;
import com.service.ThemeService;
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

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {JpaConfigureTest.class, TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class WriteStartTest {

    private static final Logger logger = LogManager.getLogger(WriteStartTest.class);

    @Autowired
    public RoleDAO roleDAO;

    @Autowired
    public RoleService roleService;

    @Autowired
    public UserDAO userDAO;

    @Autowired
    public UserService userService;

    @Autowired
    public ThemeService themeService;


    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
//    @Transactional
    public void writingStartValuesOnDBTest() {
        logger.error("HELLO");

//        Role role = new Role();

//        User user = new User("Alex0", "Login",
//                "furriets@gmail.com", "111111111", LocalDate.now(), role);
//        role = roleService.findByRoleName("admin");
//        user.setRole(role);
//        role.getUsers().add(user);
//        roleService.update(role);


//        User user2 = new User("Alex2", "Login2",
//                "furriets2@gmail.com", "333333333", LocalDate.now(), role);
//        role = roleService.findByRoleName("admin");
//        user2.setRole(role);
//        role.getUsers().add(user2);
//        roleService.update(role);
//
//        User user1 = new User("Alex1", "Login1",
//                "furriets1@gmail.com", "222222222", LocalDate.now(), role);
//        role = roleService.findByRoleName("user");
//        user1.setRole(role);
//        role.getUsers().add(user1);
//        roleService.update(role);
//
//
//        User user3 = new User("Alex3", "Login3",
//                "furriets3@gmail.com", "4444444444", LocalDate.now(), role);
//        role = roleService.findByRoleName("user");
//        user3.setRole(role);
//        role.getUsers().add(user3);
//        roleService.update(role);
//

//        User user4 = new User("Alex4", "Login4",
//                "furriets4@gmail.com", "555", LocalDate.now(), role);
//        role = roleService.findByRoleName("none");
//        user4.setRole(role);
//        role.getUsers().add(user4);
//        roleService.update(role);

        logger.error("HELLO2");
    }

    @Test
    public void writingRoleTest() {
        Role role = new Role();
        role.setNameRole("admin");
        roleService.saveRole(role);

        Role role1 = new Role();
        role1.setNameRole("user");
        roleService.saveRole(role1);

        Role role2 = new Role();
        role2.setNameRole("none");
        roleService.saveRole(role2);
    }

    @Test
    public void writingCardTest(){
        User user = new User();

//        Card card = new Card("Aval", new Integer(1232312342), user);
//        user = userService.findByLogin("Login");
//        card.setUser(user);
//        user.getCards().add(card);
//        userService.updateUser(user);

//        Card card = new Card("Privat bank", new Integer(1111111111), user);
//        user = userService.findByLogin("Login");
//        card.setUser(user);
//        user.getCards().add(card);
//        userService.updateUser(user);

//        Card card = new Card("Aval", new Integer(222222222), user);
//        user = userService.findByLogin("Login1");
//        card.setUser(user);
//        user.getCards().add(card);
//        userService.updateUser(user);
//
//        Card card = new Card("Privat bank", new Integer(222222222), user);
//        user = userService.findByLogin("Login1");
//        card.setUser(user);
//        user.getCards().add(card);
//        userService.updateUser(user);

//        Card card = new Card("Aval", new Integer(333333333), user);
//        user = userService.findByLogin("Login2");
//        card.setUser(user);
//        user.getCards().add(card);
//        userService.updateUser(user);

//        Card card = new Card("Privat bank", new Integer(333333333), user);
//        user = userService.findByLogin("Login2");
//        card.setUser(user);
//        user.getCards().add(card);
//        userService.updateUser(user);
//
//        Card card = new Card("Aval", new Integer(444444444), user);
//        user = userService.findByLogin("Login3");
//        card.setUser(user);
//        user.getCards().add(card);
//        userService.updateUser(user);
//
//        Card card = new Card("Privat bank", new Integer(444444444), user);
//        user = userService.findByLogin("Login3");
//        card.setUser(user);
//        user.getCards().add(card);
//        userService.updateUser(user);
//
//        Card card = new Card("Aval", new Integer(55555555), user);
//        user = userService.findByLogin("Login4");
//        card.setUser(user);
//        user.getCards().add(card);
//        userService.updateUser(user);
//
        Card card = new Card("Privat bank", new Integer(55555555), user);
        user = userService.findByLogin("Login4");
        card.setUser(user);
        user.getCards().add(card);
        userService.updateUser(user);
    }

    @Test
    public void injectThemeLikeFotoVideoMoneyInUser(){
        User user = new User();

        Like like = new Like();
        Foto foto = new Foto();
        Theme theme = new Theme();
        Video video = new Video();
        Money money = new Money();

        user = userService.findByLogin("Login4");

        theme.setHead("SuperProject");
        theme.setDescription("trylialia");
        theme.setDate(LocalDate.now());
        theme.setEnd_date(LocalDate.now().plusMonths(1));

        theme.setUser(user);

        like.setLogin_man(user.getLogin());
        like.setCount_likes(1);

        theme.getLikes().add(like);

        foto.setPath("asasdasdasdasdsa");
        foto.setPath2("azazazazazazazaz");
        foto.setPath3("axaxaxaxaxaxaxax");
        theme.setFoto(foto);

        video.setPath("asasdasdasdasdsa");
        video.setPath2("azazazazazazazaz");
        video.setPath3("axaxaxaxaxaxaxax");
        theme.setVideo(video);

        money.setQuantity(900000000);
        money.setGet_money(6000);
        theme.setMoney(money);


        foto.setTheme(theme);
        video.setTheme(theme);
        money.setTheme(theme);

        like.setTheme(theme);

        user.getThemes().add(theme);

        userService.updateUser(user);
    }
}
