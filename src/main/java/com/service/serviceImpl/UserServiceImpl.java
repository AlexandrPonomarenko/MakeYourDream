package com.service.serviceImpl;

import com.dao.RoleDAO;
import com.dao.UserDAO;
import com.model.Role;
import com.model.User;
import com.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
    public User findByEmail(String email) {
        User user = userDAO.findByEmail(email);
        return user;
    }

    @Override
    public void saveUser(User user) {
        user.setDate(LocalDate.now());
        Role role = roleDAO.findByRoleName("USER");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        logger.debug("Password in method saveUser " + user.getPassword());
        user.setRole(role);
        role.getUsers().add(user);
        userDAO.save(user);
    }

    @Override
    public void updateUser(User user) {
//        User entity = userDAO.findById(user.getId());
//        if(entity != null){
//            entity.setId(user.getId());
//            entity.setName(user.getName());
//            entity.setLogin(user.getLogin());
//            entity.setPassword(user.getPassword());
//        }
        userDAO.updateUser(user);

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
