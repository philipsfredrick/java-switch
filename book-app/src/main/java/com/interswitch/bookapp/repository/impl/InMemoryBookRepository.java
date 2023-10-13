package com.interswitch.bookapp.repository.impl;

import com.interswitch.bookapp.repository.BookRepository;
import com.interswitch.bookapp.repository.model.BookData;

import java.util.*;

public class InMemoryBookRepository implements BookRepository {

    private final Map<String, BookData> storedBooks;

    public InMemoryBookRepository(Map<String, BookData> storedBooks) {
        this.storedBooks = new HashMap<>();
        this.storedBooks.putAll(storedBooks);
    }

    @Override
    public Collection<BookData> findAll() {
        if (storedBooks.isEmpty()) {
            return Collections.emptyList();
        }

        return storedBooks.values();
    }

    @Override
    public Optional<BookData> findById(String isbn) {
        return Optional.ofNullable(storedBooks.get(isbn));
    }

    @Override
    public BookData add(BookData book) {
        storedBooks.put(book.getIsbn(), book);
        return book;
    }
}