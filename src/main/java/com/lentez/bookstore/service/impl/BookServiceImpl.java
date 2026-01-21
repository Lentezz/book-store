package com.lentez.bookstore.service.impl;

import com.lentez.bookstore.dto.book.BookDto;
import com.lentez.bookstore.dto.book.CreateBookRequestDto;
import com.lentez.bookstore.exception.EntityNotFoundException;
import com.lentez.bookstore.mapper.BookMapper;
import com.lentez.bookstore.repository.book.BookRepository;
import com.lentez.bookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto createBook(CreateBookRequestDto createBookRequestDto) {
        return bookMapper
                .toBookDto(
                        bookRepository.save(
                                createBookRequestDto.toBook()
                        )
                );
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository
                .findAll()
                .stream()
                .map(bookMapper::toBookDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        return bookMapper.toBookDto(
                bookRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new EntityNotFoundException(
                                        "Book with id = " + id + " not found"
                                )
                        )
        );
    }
}
