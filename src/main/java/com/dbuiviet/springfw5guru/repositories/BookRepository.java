package com.dbuiviet.springfw5guru.repositories;

import com.dbuiviet.springfw5guru.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
