package com.lbm.app.service;

import com.lbm.app.model.Book;

import java.util.List;

public interface BookService
{
    public void addBook(Book aInBook);
    public List<Book> getBooks();
}
