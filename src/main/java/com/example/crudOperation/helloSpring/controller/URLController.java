package com.example.crudOperation.helloSpring.controller;

import java.net.URI;
import java.util.Objects;

import com.example.crudOperation.helloSpring.model.URLRequest;
import com.example.crudOperation.helloSpring.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


//mark class as Controller
@RestController
public class URLController
{
    //autowire the BooksService class
    @Autowired
    UrlShortenerService urlShortenerService;
    //creating a get mapping that retrieves all the books detail from the database


    @GetMapping("/redirect/{shortURL}")
    ResponseEntity<Void> redirect(@PathVariable String shortURL) {
        String longURL = urlShortenerService.getLongURL(shortURL);
        if(Objects.equals(longURL, "")) longURL = "http://www.google.com";
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longURL))
                .build();
    }

    @PostMapping("/save")
    public String convertToShortUrl(@RequestBody URLRequest url) {
        String shortURL = urlShortenerService.createAndSaveShortURL(url.getLongURL());
        return "http:localhost:8081/redirect/" + shortURL;
    }


}