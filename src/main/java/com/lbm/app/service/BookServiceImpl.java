package com.lbm.app.service;

import com.lbm.app.dao.BookDao;
import com.lbm.app.model.Book;

import javax.transaction.Transactional;
import java.util.List;

public class BookServiceImpl implements BookService
{
    BookDao bookDao;

    public void setBookDao(BookDao aInBookDao){
        this.bookDao = aInBookDao;
    }

    @Override
    @Transactional
    public void addBook(Book aInBook) {
        bookDao.addBook(aInBook);
    }

    @Transactional
    public List<Book> getBooks(){
        return bookDao.getBooks();
    }
}
