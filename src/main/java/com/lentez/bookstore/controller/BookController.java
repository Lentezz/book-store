package com.lentez.bookstore.controller;

import com.lentez.bookstore.dto.book.BookDto;
import com.lentez.bookstore.dto.book.CreateBookRequestDto;
import com.lentez.bookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAll() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(
            @RequestBody CreateBookRequestDto createBookRequestDto) {
        return new ResponseEntity<>(
                bookService.createBook(createBookRequestDto),
                HttpStatus.CREATED
        );
    }
}
