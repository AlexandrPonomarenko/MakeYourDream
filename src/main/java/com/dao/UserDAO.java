package com.dao;

import com.model.User;

import java.util.List;

public interface UserDAO {
    User findById(int id);
    User findByLogin(String login);
    void save(User user);
    void deleteByLogin(String login);
    List<User> findAllUsers();
}
