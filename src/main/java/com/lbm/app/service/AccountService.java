package com.lbm.app.service;

import com.lbm.app.model.Account;

import java.util.List;

public interface AccountService
{
    public void addAccount(Account acc);
    public List<Account> getAccounts();
    public Account getAccountByNumber(String accNo);
    public void deleteAccount(String accNo);
}
