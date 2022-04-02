package com.example.jpademo.bootstrap;

import com.example.jpademo.domain.Book;
import com.example.jpademo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book("Domain Driven Design", "123", "RandomHouse");

        System.out.println("id: " + book.getId());

        Book savedBook = bookRepository.save(book);

        System.out.println("saved id: " + savedBook.getId());

        book  = new Book("Spring In Action", "234", "Oriely");

        savedBook = bookRepository.save(book);

        bookRepository.findAll().forEach(book1 -> {
            System.out.println("Book id: " + book1.getId());
            System.out.println("Book title: " + book1.getTitle());
        });
    }
}
