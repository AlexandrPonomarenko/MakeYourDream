package com.service.serviceImpl;

import com.dao.FotoDAO;
import com.model.Foto;
import com.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FotoServiceImpl implements FotoService{

    @Autowired
    private FotoDAO fotoDAO;

    @Override
    public Foto findById(int id) {
        return fotoDAO.findById(id);
    }
}
