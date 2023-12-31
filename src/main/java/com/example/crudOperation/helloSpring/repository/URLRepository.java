package com.example.crudOperation.helloSpring.repository;

import com.example.crudOperation.helloSpring.model.URLs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;


//repository that extends CrudRepository
@Repository
public interface URLRepository extends JpaRepository<URLs, Long>
{
    @Query("select url from URLs url")
    List<URLs> getLongURL(@Nullable String shortUrl);


}

