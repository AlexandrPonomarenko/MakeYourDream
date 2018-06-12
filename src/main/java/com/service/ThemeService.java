package com.service;

import com.model.Theme;

import java.util.List;

public interface ThemeService {
    List<Theme> findAllThemes();
    Theme findByThemeHead(String themeHead);
    Theme findById(int id);
    void saveTheme(Theme theme);
}
