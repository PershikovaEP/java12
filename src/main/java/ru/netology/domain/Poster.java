package ru.netology.domain;

public class Poster {
    private int id;
    private String title;
    private String genre;
    private String imageUrl;

    public Poster() {
    }

    public Poster(int id, String title, String genre, String imageUrl) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
