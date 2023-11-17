package com.axonactive;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.HttpHeaders;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void shouldGetAllBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when().get("/books")
                .then()
                .statusCode(200)
                .body("size()", is(2));
    }

    @Test
    public void shouldGetNumberOfTheBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .when().get("/books/count")
                .then().statusCode(200).body(is("2"));
    }

    @Test
    public void shouldGetBookById() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).pathParam("id", 1)
                .when().get("/books/{id}")
                .then().statusCode(200)
                .body("id", is(1))
                .body("name", is("Book 2"))
                .body("author", is("Author 2"))
                .body("yearOfPublication", is(2020))
                .body("genre", is("IT"));
    }
}