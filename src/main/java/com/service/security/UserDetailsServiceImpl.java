package com.service.security;

import com.dao.UserDAO;
import com.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
        logger.debug("it is loadUserByUsername method " + userLogin);
        User user = userDAO.findByLogin(userLogin);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getNameRole()));
        for(GrantedAuthority grantedAuthority : grantedAuthorities){
            logger.debug("grant user " + grantedAuthority);
        }

        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                                                                    user.getPassword(),
                                                                    grantedAuthorities);
    }
}
