package com.example.bankapp.dao;

import com.example.bankapp.entity.TransactionRecord;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

@Repository
public class TransactionDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(TransactionRecord tr) {
        sessionFactory.getCurrentSession().save(tr);
    }
}
