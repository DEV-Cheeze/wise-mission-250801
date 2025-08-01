package com.back.domain;

public class WiseSaying {

    int id;
    String author;
    String poem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPoem() {
        return poem;
    }

    public void setPoem(String poem) {
        this.poem = poem;
    }

    public void update(String author, String poem){
        this.author = author;
        this.poem = poem;
    }

}
