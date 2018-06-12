package com.sconfig;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
//@EnableTransactionManagement
//@PropertySource("classpath:application.properties")
//public class ConfigDB {
//
//    @Autowired
//    private Environment environment;
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(){
//        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
//        lcemfb.setJpaVendorAdapter(getJpaVendorAdapter());
//        lcemfb.setDataSource(getDataSource());
////        lcemfb.setPersistenceUnitName("myJpaPersistenceUnit");
//        lcemfb.setPackagesToScan("com.model");
//        lcemfb.setJpaProperties(jpaProperties());
//        return lcemfb;
//    }
//
//    @Bean
//    public DataSource getDataSource(){
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
//        dataSource.setUrl(environment.getProperty("jdbc.url"));
//        dataSource.setUsername(environment.getProperty("jdbc.username"));
//        dataSource.setPassword(environment.getProperty("jdbc.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public JpaVendorAdapter getJpaVendorAdapter(){
//        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        return adapter;
//    }
//
//    @Bean
//    public PlatformTransactionManager txManager(){
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
//                getEntityManagerFactoryBean().getObject());
//        return jpaTransactionManager;
//    }
//
//    private Properties jpaProperties(){
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//        properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
//        return properties;
//    }
//}
