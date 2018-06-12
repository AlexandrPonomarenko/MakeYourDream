package com.dao.daoImpl;

import com.service.serviceImpl.RoleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.dao.daoImpl",
                                "com.model",
                                "com.service.serviceImpl"})
public class TestConfig {

    @Bean
    public RoleImpl getRoleImpl(){
        return new RoleImpl();
    }

    @Bean
    public RoleServiceImpl getRoleServiceImpl(){
        return new RoleServiceImpl();
    }

}
