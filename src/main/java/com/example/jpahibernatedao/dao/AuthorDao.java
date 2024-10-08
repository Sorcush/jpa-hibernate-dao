package com.example.jpahibernatedao.dao;


import com.example.jpahibernatedao.entities.Author;

public interface AuthorDao {
    Author findById(Long id);
    Author findByIdWithBooks(Long id);
    Author findByName(String firstName, String lastName);
    Author save(Author author);
    Author update(Author author);
    void delete(Long id);
}
