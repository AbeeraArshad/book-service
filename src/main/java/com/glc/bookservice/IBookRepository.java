package com.glc.bookservice;

import java.util.Collection;

public interface IBookRepository<T> {
    public void save(T t);

    public Collection<T> getAllBooks();

    public Book getById(int id);

    public String deleteBook(int id);

    public String updateBook(int id,T t);
}
