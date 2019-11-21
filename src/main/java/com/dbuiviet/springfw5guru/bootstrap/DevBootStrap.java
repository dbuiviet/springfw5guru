package com.dbuiviet.springfw5guru.bootstrap;

import com.dbuiviet.springfw5guru.model.Author;
import com.dbuiviet.springfw5guru.model.Book;
import com.dbuiviet.springfw5guru.model.Publisher;
import com.dbuiviet.springfw5guru.repositories.AuthorRepository;
import com.dbuiviet.springfw5guru.repositories.BookRepository;
import com.dbuiviet.springfw5guru.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Publisher harper = new Publisher("Harper Collins", "12 West Road, CA");
        Publisher wrox = new Publisher("Wrox", "24 East Road, NY");

        publisherRepository.save(harper);
        publisherRepository.save(wrox);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", wrox);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
