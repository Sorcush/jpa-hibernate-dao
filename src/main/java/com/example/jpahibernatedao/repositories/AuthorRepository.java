package com.example.jpahibernatedao.repositories;

import com.example.jpahibernatedao.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
