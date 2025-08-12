package com.lentez.bookstore.repository.book;

import com.lentez.bookstore.model.Book;
import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
