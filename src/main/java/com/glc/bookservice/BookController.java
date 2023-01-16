package com.glc.bookservice;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books") // Any address like https://localhost:8080/books
public class BookController {
    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @PostMapping("") // (POST) https://localhost:8080/books
    public void createBook(@RequestBody Book book) {
        this.repository.save(book);
    }

    @GetMapping("/all") // (GET) https://localhost:8080/books/all
    public Collection<Book> getAllBooks() {
        return this.repository.getAllBooks();

    }

    @GetMapping("/{id}") // (GET) https://localhost:8080/books/all
    public Book getById(@PathVariable int id) {
        return this.repository.getById(id);
    }

    @DeleteMapping("/delete/{id}") // (DELETE) https://localhost:8080/books/id
    public String deleteBook(@PathVariable int id) {
        this.repository.deleteBook(id);
        return "book successfully deleted";
    }
    @UpdateMapping("/update/{id}") // (UPDATE) https://localhost:8080/books/id
      public void updateBook(@RequestBody int id, Book book){
       this.repository.updateBook(id, book);
    }


}