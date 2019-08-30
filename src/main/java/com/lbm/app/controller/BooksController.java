package com.lbm.app.controller;

import com.lbm.app.model.Book;
import com.lbm.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController
{
    BookService bookService;

    @Autowired
    @Qualifier(value = "bookService")
    public void setBookService(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping(value = "/",method= RequestMethod.POST)
    public ResponseEntity<String> addBook(@RequestBody Book aInBook)
    {
        bookService.addBook(aInBook);
        return new ResponseEntity<>("Book Added Successfuly",HttpStatus.OK);
    }

    @RequestMapping(value="/",method=RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> books = bookService.getBooks();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }
}
