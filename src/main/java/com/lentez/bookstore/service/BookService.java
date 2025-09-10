package com.lentez.bookstore.service;

import com.lentez.bookstore.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
