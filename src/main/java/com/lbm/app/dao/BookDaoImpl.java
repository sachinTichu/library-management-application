package com.lbm.app.dao;

import com.lbm.app.model.Book;
import com.lbm.app.service.BookService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addBook(Book aInBook) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(aInBook);
    }

    public List<Book> getBooks(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> booksList = session.createQuery("from Book").list();
        return booksList;
    }
}
