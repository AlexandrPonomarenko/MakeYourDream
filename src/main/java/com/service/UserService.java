package com.service;

import com.model.User;

import java.util.List;

public interface UserService {
    User findById(int id);
    User findByLogin(String login);
    User findByEmail(String email);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(String login);
    List<User> findAllUsers();
    boolean isUserLoginUnique(Integer id, String login);
}
