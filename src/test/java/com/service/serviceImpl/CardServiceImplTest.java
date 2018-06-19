package com.service.serviceImpl;

import com.dao.daoImpl.TestConfig;
import com.model.Card;
import com.model.User;
import com.service.CardService;
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

import java.util.List;

import static org.junit.Assert.*;
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {JpaConfigureTest.class, TestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class CardServiceImplTest {

    private static final Logger logger = LogManager.getLogger(CardServiceImplTest.class);

    @Autowired
    CardService cardService;

    @Autowired
    UserService userService;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllCards() {
        logger.warn("findAllCards");
        List<Card> cards = cardService.findAllCards();
        assertEquals(10, cards.size());

        for(Card card: cards){
            System.out.println(card.toString());
        }
    }

//    @Test
//    public void findByCardBankName() {
//        logger.warn("findByCardBankName");
//        Card card = cardService.findByCardBankName("Aval");
//        assertEquals("Avel", card.getName_bank());
//    }

    @Test
    public void findByCardNumber() {
        logger.warn("findByCardNumber");
        Card card = cardService.findByCardNumber(1111111111);
        Integer a = card.getNumber_card();
        Integer b = 1111111111;
        assertEquals(b.longValue(), a.longValue());
    }

    @Test
    public void findById() {
        logger.warn("findById");
        Card card = cardService.findById(7);
        assertEquals(7, (int)card.getId());
    }

    @Test
    @Transactional
    public void deleteByIdNumberCard() {
        logger.warn("deleteByIdNumberCard");

        List<Card> cards = cardService.findAllCards();
        assertEquals(10, cards.size());

        cardService.deleteByIdNumberCard(1111111111);

        List<Card> cards1 = cardService.findAllCards();
        assertEquals(9, cards1.size());

    }

    @Test
    @Transactional
    public void updateCard() {
        logger.warn("updateCard");
        Card card = cardService.findByCardNumber(1232312342);
        assertEquals("Aval", card.getName_bank());
        card.setName_bank("Petro");
        cardService.updateCard(card);

        User user = userService.findByLogin("Login");
        for(Card card1: user.getCards()){
            System.out.println(card1.toString());
        }
    }
}