package com.service;

import com.model.Card;

import java.util.List;

public interface CardService {
    List<Card> findAllCards();
    Card findByCardBankName(String bankName);
    Card findByCardNumber(Integer numberCard);
    Card findById(int id);
    void deleteByIdNumberCard(Integer numberCard);
    void updateCard(Card card);
}
