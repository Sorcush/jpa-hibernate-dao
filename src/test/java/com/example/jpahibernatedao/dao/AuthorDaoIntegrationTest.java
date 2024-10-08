package com.example.jpahibernatedao.dao;

import com.example.jpahibernatedao.entities.Author;
import org.springframework.test.context.ActiveProfiles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"com.example.jpajdbctemplate.dao"})
class AuthorDaoIntegrationTest {
    @Autowired
    private AuthorDao authorDao;

    @Test
    void testFindById() {
        Author author = authorDao.findById(1L);
        assertThat(author).isNotNull();

        author = authorDao.findByIdWithBooks(1L);
        assertThat(author.getBooks()).hasSize(3);
    }

    @Test
    void testGetByName() {
        Author author = authorDao.findByName("Craig", "Walls");
        assertThat(author).isNotNull();
    }

    @Test
    void testSave() {
        Author author = new Author("Michael", "Jackson");
        Author savedAuthor = authorDao.save(author);
        assertThat(savedAuthor).isNotNull();
    }

    @Test
    void testUpdate() {
        Author author = new Author("Michael", "Jackson");
        Author savedAuthor = authorDao.save(author);
        savedAuthor.setLastName("Jordan");
        Author updatedAuthor = authorDao.update(savedAuthor);

        assertThat(updatedAuthor.getLastName()).isEqualTo("Jordan");
    }

    @Test
    void testDelete() {
        Author author = new Author("Michael", "Jackson");
        Author savedAuthor = authorDao.save(author);
        authorDao.delete(savedAuthor.getId());
        Long id = savedAuthor.getId();
        assertThrows(EmptyResultDataAccessException.class, () -> authorDao.findById(id));
    }
}