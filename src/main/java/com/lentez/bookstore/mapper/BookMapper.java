package com.lentez.bookstore.mapper;

import com.lentez.bookstore.dto.book.BookDto;
import com.lentez.bookstore.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDto toBookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPrice(),
                book.getDescription(),
                book.getCoverImage()
        );
    }

    public Book toBookEntity(BookDto bookDto) {
        return new Book(
                bookDto.id(),
                bookDto.title(),
                bookDto.author(),
                bookDto.isbn(),
                bookDto.price(),
                bookDto.description(),
                bookDto.coverImage()
        );
    }
}
