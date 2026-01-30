package com.lentez.bookstore.service;

import com.lentez.bookstore.dto.book.BookDto;
import com.lentez.bookstore.dto.book.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto createBook(CreateBookRequestDto book);

    List<BookDto> findAll();

    BookDto findById(Long id);
}
