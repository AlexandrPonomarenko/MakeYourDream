package com.dao;

import com.model.Card;

import java.util.List;

public interface CardDAO {
    List<Card> findAllCards();
    Card findByCardBankName(String bankName);
    Card findByCardNumber(Integer numberCard);
    Card findById(int id);
    void deleteByNumberCard(Integer numberCard);
    void updateCard(Card card);
}
