package pl.maprzybysz.springboot2.model;

import java.time.LocalDate;

public class Movie {
    private String title;
    private String producer;
    private LocalDate release;

    public Movie() {
    }

    public Movie(String title, String producer, LocalDate release) {
        this.title = title;
        this.producer = producer;
        this.release = release;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", producer='" + producer + '\'' +
                ", release=" + release +
                '}';
    }
}
