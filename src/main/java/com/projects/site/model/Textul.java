package com.projects.site.model;

public class Textul {
    String text;
    long id;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Textul(String text, long id) {
        this.text = text;
        this.id = id;
    }
}
