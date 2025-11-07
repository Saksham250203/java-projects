package com.example.bankapp.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration as SpringConfiguration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.TransactionRecord;

@SpringConfiguration
@ComponentScan(basePackages = "com.example.bankapp")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(TransactionRecord.class)
                .buildSessionFactory();
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }
}
