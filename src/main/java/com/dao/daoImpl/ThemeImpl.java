package com.dao.daoImpl;

import com.dao.AbstractDAO;
import com.dao.ThemeDAO;
import com.model.Theme;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("ThemeDAO")
public class ThemeImpl extends AbstractDAO<Integer, Theme> implements ThemeDAO{

    @SuppressWarnings("unchecked")
    @Override
    public List<Theme> findAllThemes() {
        List<Theme> themes = getEntityManager()
                .createQuery("SELECT t FROM Theme t ORDER BY t.head ASC")
                .getResultList();
        return themes;
    }

    @Override
    public Theme findByThemeHead(String themeHead) {
        try {
            Theme theme = (Theme) getEntityManager()
                    .createQuery("SELECT t FROM Theme t WHERE t.head LIKE :head")
                    .setParameter("head", themeHead)
                    .getSingleResult();
            return theme;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Theme findById(int id) {
        return getByKey(id);
    }
}
