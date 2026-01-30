package com.lentez.bookstore.mapper;

import com.lentez.bookstore.config.MapperConfig;
import com.lentez.bookstore.dto.book.CreateBookRequestDto;
import com.lentez.bookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface CreateBookRequestMapper {

    Book toBook(CreateBookRequestDto book);
}
