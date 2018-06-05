package com.dao.daoImpl;

import com.dao.AbstractDAO;
import com.dao.CardDAO;
import com.model.Card;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("CardDAO")
public class CardImpl extends AbstractDAO<Integer, Card> implements CardDAO{

    @SuppressWarnings("unchecked")
    @Override
    public List<Card> findAllCards() {
        List<Card> cards =  getEntityManager()
                .createQuery("SELECT c FROM Card c ORDER BY r.name_bank ASC")
                .getResultList();
        return cards;
    }

    @Override
    public Card findByCardBankName(String bankName) {
        try {
            Card card = (Card) getEntityManager()
                    .createQuery("SELECT c FROM Card c WHERE c.name_bank LIKE :name_bank")
                    .setParameter("name_bank", bankName)
                    .getSingleResult();
            return card;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Card findByCardNumber(Integer numberCard) {
        try {
            Card card = (Card) getEntityManager()
                    .createQuery("SELECT c FROM Card c WHERE c.number_card LIKE :number_card")
                    .setParameter("number_card", numberCard)
                    .getSingleResult();
            return card;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void deleteByNumberCard(Integer numberCard) {
        Card card = (Card) getEntityManager()
                .createQuery("SELECT c FROM Card c WHERE c.number_card LIKE :number_card")
                .setParameter("number_card", numberCard)
                .getSingleResult();
        delete(card);
    }

    @Override
    public Card findById(int id) {
        return getByKey(id);
    }
}
