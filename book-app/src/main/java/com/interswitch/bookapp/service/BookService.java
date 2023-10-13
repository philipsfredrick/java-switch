package com.interswitch.bookapp.service;

import com.interswitch.bookapp.dto.Book;

import java.util.Collection;

public interface BookService {
    Collection<Book> getBooks();

    Book addBook(Book book);
}