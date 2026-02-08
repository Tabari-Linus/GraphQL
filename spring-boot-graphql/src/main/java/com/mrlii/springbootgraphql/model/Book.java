package com.mrlii.springbootgraphql.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public record Book(
Integer id,
String name,
Integer pageCount,
Integer authorId
) {

    public static List<Book>  books = Arrays.asList(
            new Book(1, "Harry Potter and the Philosopher's Stone", 223, 1),
            new Book(2, "Moby Dick", 635, 3),
            new Book(3, "Interview with the vampire", 371,2),
            new Book(4, "The Lord of the Rings", 1178,1)
    );

    public static Optional<Book> getBookById(Integer id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst();
    }
}
