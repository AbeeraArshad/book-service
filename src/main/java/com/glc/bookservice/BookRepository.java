package com.glc.bookservice;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository implements IBookRepository<Book> {
    private Map<Integer, Book> repository;

    public BookRepository() {
        this.repository = new HashMap<>();
    }

    @Override
    public void save(Book book) {
        repository.put(book.getId(), book);
    }

    @Override
    public Collection<Book> getAllBooks() {
        return repository.values();
    }

    @Override
    public Book getById(int id) {
        return repository.get(id);
    }

    @Override
    public String deleteBook(int id) {
        repository.remove(id);
        return "book deleted";
    }

    @Override
    public String updateBook(int id, Book book) {
        // TODO Auto-generated method stub
        this.repository.put(id,book);
        return "Book Updated";
    }

    

    

}
