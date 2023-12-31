package com.example.crudOperation.helloSpring.model;

import java.io.Serializable;

public class URLRequest implements Serializable {

    String longURL;

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }
}
