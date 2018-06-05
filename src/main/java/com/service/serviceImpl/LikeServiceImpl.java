package com.service.serviceImpl;

import com.dao.LikeDAO;
import com.model.Like;
import com.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LikeServiceImpl implements LikeService{

    @Autowired
    private LikeDAO likeDAO;

    @Override
    public Like findById(int id) {
        return likeDAO.findById(id);
    }
}
