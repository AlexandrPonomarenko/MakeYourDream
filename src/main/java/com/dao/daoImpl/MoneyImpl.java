package com.dao.daoImpl;

import com.dao.AbstractDAO;
import com.dao.MoneyDAO;
import com.model.Money;
import org.springframework.stereotype.Repository;

@Repository("moneyDAO")
public class MoneyImpl extends AbstractDAO<Integer, Money> implements MoneyDAO {

    @Override
    public Money findById(int id) {
        return null;
    }
}
