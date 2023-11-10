package com.example.crudOperation.helloSpring.repository;

import com.example.crudOperation.helloSpring.model.Books;
import org.springframework.data.repository.CrudRepository;
//repository that extends CrudRepository
public interface BooksRepository extends CrudRepository<Books, Integer>
{
}

