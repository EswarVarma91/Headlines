package com.amigoentertainments.apps.headlinessizeminimize;

public class Actors {

    private String author;
    private String description;
    private String publishedAt;
    private String url;
    private String title;
    private String image;

    public Actors() {
        // TODO Auto-generated constructor stub
    }

    public Actors(String author, String description, String publishedAt, String url, String title, String image) {
        super();
        this.author = author;
        this.description = description;
        this.publishedAt = publishedAt;
        this.url = url;
        this.title = title;
        this.image = image;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
