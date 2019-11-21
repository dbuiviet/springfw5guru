package com.dbuiviet.springfw5guru.repositories;

import com.dbuiviet.springfw5guru.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
