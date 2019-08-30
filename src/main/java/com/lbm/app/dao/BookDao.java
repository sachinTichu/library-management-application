package com.lbm.app.dao;

import com.lbm.app.model.Book;

import java.util.List;

public interface BookDao
{
    public void addBook(Book aInBook);
    public List<Book> getBooks();
}
