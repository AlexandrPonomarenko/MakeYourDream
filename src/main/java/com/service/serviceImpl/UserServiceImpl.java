package com.service.serviceImpl;

import com.dao.UserDAO;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public User findByLogin(String login) {
        User user = userDAO.findByLogin(login);
        return user;
    }

    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    public void updateUser(User user) {
        User entity = userDAO.findById(user.getId());
        if(entity != null){
            entity.setId(user.getId());
            entity.setName(user.getName());
            entity.setLogin(user.getLogin());
            entity.setPassword(user.getPassword());
        }
    }

    @Override
    public void deleteUser(String login) {
        userDAO.deleteByLogin(login);
    }

    @Override
    public List<User> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public boolean isUserLoginUnique(Integer id, String login) {
        User user = findByLogin(login);
        return (user == null || ((id != null) && (user.getId() == id)));
    }
}
