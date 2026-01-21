package com.lentez.bookstore.dto.book;

import com.lentez.bookstore.model.Book;
import java.math.BigDecimal;

public record CreateBookRequestDto(
        String title,
        String author,
        String isbn,
        BigDecimal price,
        String description,
        String coverImage
) {

    public Book toBook() {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setPrice(price);
        book.setDescription(description);
        book.setCoverImage(coverImage);
        return book;
    }
}
