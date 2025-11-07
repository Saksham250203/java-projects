package com.example.bankapp;

import com.example.bankapp.config.AppConfig;
import com.example.bankapp.service.BankService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        BankService service = context.getBean(BankService.class);

        try {
            service.transferMoney(1, 2, 500);
        } catch (Exception e) {
            System.out.println("❌ Transaction failed: " + e.getMessage());
        }

        context.close();
    }
}
