package com.lbm.app.service;

import com.lbm.app.dao.AccountDao;
import com.lbm.app.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    AccountDao accountDao;

    @Autowired
    @Qualifier(value="accountDao")
    public void setAccountDao(AccountDao aInAccountDao){
        this.accountDao = aInAccountDao;
    }

    @Override
    @Transactional
    public void addAccount(Account acc) {
        accountDao.addAccount(acc);
    }

    @Override
    @Transactional
    public List<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    @Override
    @Transactional
    public Account getAccountByNumber(String accNo) {
        return accountDao.getAccountByNumber(accNo);
    }

    @Override
    @Transactional
    public void deleteAccount(String accNo) {
        accountDao.deleteAccount(accNo);
    }
}
