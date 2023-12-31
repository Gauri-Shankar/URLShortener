package com.example.crudOperation.helloSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import com.example.crudOperation.helloSpring.model.URLs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crudOperation.helloSpring.repository.URLRepository;

//defining the business logic
@Service
public class UrlShortenerService
{
    @Autowired
    URLRepository URLRepository;


    public String getLongURL(String urlShortenedCode){
        List<URLs> longURLList = URLRepository.getLongURL(urlShortenedCode);
        URLs answerURL = null;
        for(URLs url: longURLList){
            if(urlShortenedCode.equals(url.getShortenedURL())){
                answerURL = url;
                break;
            }
        }
        if(answerURL != null) return answerURL.getLongURL();
        return "";
    }

    public String createAndSaveShortURL(String longUrl){
        ArrayList<Character> arrayList = createCharacterMap();
        String shortURL = generateRandom(arrayList);

        URLRepository.save(new URLs(shortURL, longUrl));

        return shortURL;
    }

    public static String generateRandom(ArrayList<Character> mp){
        Random rand = new Random();

        StringBuilder resultingString = new StringBuilder();

        for(int i=0;i<8;i++){
            int randomNumber = rand.nextInt(62);
            resultingString.append(mp.get(randomNumber));
        }

        return resultingString.toString();
    }

    public static ArrayList<Character> createCharacterMap(){

        ArrayList<Character> mp = new ArrayList<Character>();

        for(int i=0;i<10;i++){
            mp.add((char)('0' + i));
        }

        for(int i=10;i<=35;i++){
            mp.add((char)('a' + (i - 10)));
        }

        for(int i=36;i<62;i++){
            mp.add((char)('A' + (i - 36)));
        }

        return mp;

    }


}