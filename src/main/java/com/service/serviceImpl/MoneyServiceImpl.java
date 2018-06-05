package com.service.serviceImpl;

import com.dao.MoneyDAO;
import com.model.Money;
import com.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MoneyServiceImpl implements MoneyService{

    @Autowired
    private MoneyDAO moneyDAO;

    @Override
    public Money findById(int id) {
        return moneyDAO.findById(id);
    }
}
