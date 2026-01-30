package com.lentez.bookstore.mapper;

import com.lentez.bookstore.config.MapperConfig;
import com.lentez.bookstore.dto.book.BookDto;
import com.lentez.bookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {

    BookDto toBookDto(Book book);

    Book toBookEntity(BookDto bookDto);
}
