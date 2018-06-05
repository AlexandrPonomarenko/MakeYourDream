package com.service.serviceImpl;

import com.dao.ThemeDAO;
import com.model.Theme;
import com.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ThemeServiceImpl implements ThemeService{

    @Autowired
    private ThemeDAO themeDAO;

    @Override
    public List<Theme> findAllThemes() {
        return themeDAO.findAllThemes();
    }

    @Override
    public Theme findByThemeHead(String themeHead) {
        return themeDAO.findByThemeHead(themeHead);
    }

    @Override
    public Theme findById(int id) {
        return themeDAO.findById(id);
    }
}
