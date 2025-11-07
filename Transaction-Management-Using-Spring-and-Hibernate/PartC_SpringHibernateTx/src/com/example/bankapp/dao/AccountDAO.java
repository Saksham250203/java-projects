package com.example.bankapp.dao;

import com.example.bankapp.entity.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

@Repository
public class AccountDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Account getAccountById(int id) {
        return sessionFactory.getCurrentSession().get(Account.class, id);
    }

    public void updateAccount(Account acc) {
        sessionFactory.getCurrentSession().update(acc);
    }
}
