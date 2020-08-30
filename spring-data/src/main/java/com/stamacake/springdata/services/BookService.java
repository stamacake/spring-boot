package com.stamacake.springdata.services;


import com.stamacake.springdata.entities.Book;
import com.stamacake.springdata.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Page<Book> findAll(Specification<Book> spec, int page, int size) {
        return bookRepository.findAll(spec, PageRequest.of(page, size));
    }

}
