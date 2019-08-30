package com.lbm.app.dao;


import com.lbm.app.model.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao
{
    private static final Logger logger = LoggerFactory.getLogger(AccountDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addAccount(Account acc) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(acc);
    }

    @Override
    public List<Account> getAccounts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Account> accountsList = session.createQuery("from Account").list();
        return accountsList;
    }

    @Override
    public Account getAccountByNumber(String accNo) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT * FROM Account a WHERE a.accNumber=:accNo");
        query.setParameter("accNo", accNo);
        return (Account) query.uniqueResult();
    }

    @Override
    public void deleteAccount(String accNo) {

    }
}
