package com.example.jpahibernatedao.repositories;

import com.example.jpahibernatedao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

