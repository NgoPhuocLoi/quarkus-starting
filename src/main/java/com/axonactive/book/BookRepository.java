package com.axonactive.book;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "Sci-fi")
    String genre;

    public List<Book> getAllBooks() {
        List<Book> books = List.of(
                new Book(0, "Book 1", "Author 1", 2019, genre),
                new Book(1, "Book 2", "Author 2", 2020, genre));

        return books;
    }

    public int getNumberOfBooks() {
        return getAllBooks().size();
    }

    public Optional<Book> getBookById(int id) {
        return getAllBooks().stream().filter(b -> b.getId() == id).findFirst();
    }
}
