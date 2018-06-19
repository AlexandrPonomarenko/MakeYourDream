package com.dao.daoImpl;

import com.dao.AbstractDAO;
import com.dao.ThemeDAO;
import com.model.Theme;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.List;

@Repository("themeDAO")
public class ThemeImpl extends AbstractDAO<Integer, Theme> implements ThemeDAO{

    @SuppressWarnings("unchecked")
    @Override
    public List<Theme> findAllThemes() {
        List<Theme> themes = getEntityManager()
                .createQuery("SELECT t FROM Theme t ORDER BY t.head ASC")
                .getResultList();
        if (themes != null){
            for (Theme theme: themes){
                initializeCollection(theme.getLikes());
            }
        }
        return themes;
    }

    @Override
    public Theme findByThemeHead(String themeHead) {
        try {
            Theme theme = (Theme) getEntityManager()
                    .createQuery("SELECT t FROM Theme t WHERE t.head LIKE :head")
                    .setParameter("head", themeHead)
                    .getSingleResult();

            if(theme != null){
                initializeCollection(theme.getLikes());
            }
            return theme;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Theme findById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveTheme(Theme theme) {
        persist(theme);
    }

    @Override
    public void updateTheme(Theme theme) {
        update(theme);
    }

    @Override
    public void deleteTheme(Theme theme) {
        delete(theme);
    }

    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }
}
