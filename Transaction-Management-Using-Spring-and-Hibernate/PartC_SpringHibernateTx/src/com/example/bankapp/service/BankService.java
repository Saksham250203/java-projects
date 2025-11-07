package com.example.bankapp.service;

import com.example.bankapp.dao.AccountDAO;
import com.example.bankapp.dao.TransactionDAO;
import com.example.bankapp.entity.Account;
import com.example.bankapp.entity.TransactionRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    @Transactional
    public void transferMoney(int fromId, int toId, double amount) {
        Account fromAcc = accountDAO.getAccountById(fromId);
        Account toAcc = accountDAO.getAccountById(toId);

        if (fromAcc == null || toAcc == null) {
            throw new RuntimeException("Account not found!");
        }

        if (fromAcc.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance!");
        }

        fromAcc.setBalance(fromAcc.getBalance() - amount);
        toAcc.setBalance(toAcc.getBalance() + amount);

        accountDAO.updateAccount(fromAcc);
        accountDAO.updateAccount(toAcc);

        TransactionRecord record = new TransactionRecord(fromAcc.getName(), toAcc.getName(), amount);
        transactionDAO.save(record);

        System.out.println("✅ Transaction Successful: " + record);
    }
}
