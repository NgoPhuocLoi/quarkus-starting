package com.axonactive.book;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @Inject
    Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Return all books");
        return bookRepository.getAllBooks();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int getNumberOfBooks() {
        logger.info("Return the number of the books");
        return bookRepository.getNumberOfBooks();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBookById(@PathParam("id") int id) {
        logger.info("Return a book with id: " + id);
        return bookRepository.getBookById(id);
    }
}
