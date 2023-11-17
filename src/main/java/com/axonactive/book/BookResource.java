package com.axonactive.book;

import java.util.List;
import java.util.Optional;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @GET
    public List<Book> getAllBooks() {
        List<Book> books = List.of(
                new Book(0, "Book 1", "Author 1", 2019, "Romatic"),
                new Book(1, "Book 2", "Author 2", 2020, "Genre2"));

        return books;
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int getNumberOfBooks() {
        return getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBookById(@PathParam("id") int id) {
        return getAllBooks().stream().filter(b -> b.getId() == id).findFirst();
    }
}
