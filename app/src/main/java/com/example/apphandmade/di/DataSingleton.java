package com.example.apphandmade.di;

import com.example.apphandmade.views.auth.model.Account;

public class DataSingleton {
    private static DataSingleton instance;
    private Account account;

    private DataSingleton() {
        // Private constructor to prevent instantiation
    }

    public static synchronized DataSingleton getInstance() {
        if (instance == null) {
            instance = new DataSingleton();
        }
        return instance;
    }

    public void setAccountInfo(Account account) {
        this.account = account;
    }

    public Account getAccountInfo() {
        return account;
    }
}
