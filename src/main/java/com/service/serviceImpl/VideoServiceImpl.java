package com.service.serviceImpl;

import com.dao.VideoDAO;
import com.model.Video;
import com.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDAO videoDAO;

    @Override
    public Video findById(int id) {
        return videoDAO.findById(id);
    }
}
