package com.dao.daoImpl;

import com.dao.AbstractDAO;
import com.dao.VideoDAO;
import com.model.Video;
import org.springframework.stereotype.Repository;

@Repository("videoDAO")
public class VideoImpl extends AbstractDAO<Integer, Video> implements VideoDAO {
    @Override
    public Video findById(int id) {
        return getByKey(id);
    }
}
