package com.service.security;

public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String login, String password);
}
