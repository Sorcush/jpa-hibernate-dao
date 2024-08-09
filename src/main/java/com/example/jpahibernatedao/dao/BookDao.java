package com.example.jpahibernatedao.dao;


import com.example.jpahibernatedao.entities.Book;

public interface BookDao {
    Book findById(Long id);
    Book findByTitle(String title);
    Book save(Book book);
    Book update(Book book);
    void delete(Long id);
}
