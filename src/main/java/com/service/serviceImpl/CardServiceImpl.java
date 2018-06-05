package com.service.serviceImpl;

import com.dao.CardDAO;
import com.model.Card;
import com.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardServiceImpl implements CardService{

    @Autowired
    private CardDAO cardDAO;

    @Override
    public List<Card> findAllCards() {
        return cardDAO.findAllCards();
    }

    @Override
    public Card findByCardBankName(String bankName) {
        Card card = cardDAO.findByCardBankName(bankName);
        return card;
    }

    @Override
    public Card findByCardNumber(Integer numberCard) {
        Card card = cardDAO.findByCardNumber(numberCard);
        return card;
    }

    @Override
    public Card findById(int id) {
        return cardDAO.findById(id);
    }

    @Override
    public void deleteByIdNumberCard(Integer numberCard) {
        cardDAO.deleteByNumberCard(numberCard);
    }
}
