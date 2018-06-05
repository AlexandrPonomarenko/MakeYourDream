package com.dao.daoImpl;

import com.dao.AbstractDAO;
import com.dao.LikeDAO;
import com.model.Like;
import org.springframework.stereotype.Repository;

@Repository("LikeDAO")
public class LikeImpl extends AbstractDAO<Integer, Like> implements LikeDAO{

    @Override
    public Like findById(int id) {
        return getByKey(id);
    }
}
