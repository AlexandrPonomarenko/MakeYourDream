package com.dao;


import com.model.Theme;

import java.util.List;

public interface ThemeDAO {
    List<Theme> findAllThemes();
    Theme findByThemeHead(String themeHead);
    Theme findById(int id);
}
