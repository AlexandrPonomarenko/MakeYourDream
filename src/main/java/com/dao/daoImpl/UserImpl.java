package com.dao.daoImpl;

import com.dao.AbstractDAO;
import com.dao.UserDAO;
import com.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Collection;
import java.util.List;

@Repository("UserDAO")
public class UserImpl extends AbstractDAO<Integer, User> implements UserDAO{

    public User findById(int id) {
        User user = getByKey(id);
        if(user != null){
            initializeCollection(user.getThemes());
        }
        return user;
    }


    public User findByLogin(String login) {
        try {
            User user = (User) getEntityManager()
                    .createQuery("SELECT u FROM User u WHERE u.login LIKE :login")
                    .setParameter("login", login)
                    .getSingleResult();
            return user;
        }catch (NoResultException e){
            return null;
        }
    }


    public void save(User user) {
        persist(user);
    }

    public void deleteByLogin(String login) {
        User user = (User) getEntityManager()
                .createQuery("SELECT u FROM User u WHERE u.login LIKE : login")
                .setParameter("login", login)
                .getSingleResult();
        delete(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        List<User> users = getEntityManager()
                .createQuery("SELECT u FROM User u ORDER BY u.name ASC")
                .getResultList();
        return users;
    }

    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }
}
