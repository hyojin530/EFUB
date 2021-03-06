package com.efub.jpapractice.repository;

import com.efub.jpapractice.domain.Author;
import com.efub.jpapractice.domain.Book;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    void manyToManyTest(){
        Book book1 = givenBook("책1");
        Book book2 = givenBook("책2");
        Book book3 = givenBook("책3");

        Author author1 = givenAuthor("efub");
        Author author2 = givenAuthor("ewha");

        book1.addAuthor(author1);
        book2.addAuthor(author2);
        book3.addAuthor(author1, author2);

        author1.addBook(book1, book3);
        author2.addBook(book2, book3);

        bookRepository.saveAll(Lists.newArrayList(book1, book2, book3));
        authorRepository.saveAll(Lists.newArrayList(author1, author2));

        System.out.println("result => "+ bookRepository.findAll().get(2).getAuthors());
    }

    private Book givenBook(String name){
        Book book = new Book();
        book.setName(name);

        return bookRepository.save(book);
    }

    private Author givenAuthor(String name){
        Author author = new Author();
        author.setName(name);

        return authorRepository.save(author);
    }
}