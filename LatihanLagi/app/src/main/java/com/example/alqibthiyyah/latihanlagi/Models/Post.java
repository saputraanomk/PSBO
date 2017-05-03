package com.example.alqibthiyyah.latihanlagi.Models;

/**
 * Created by Alqibthiyyah on 03/05/2017.
 */

public class Post {
    private String title, body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}

