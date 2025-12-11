package se.chasacademy.databaser.wsjpa.blog.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    @Column
    private String title, posttext, author;
    @Column
    private LocalDateTime publishDate, createDate;

    public Post (){
        publishDate = LocalDateTime.now();
        createDate = LocalDateTime.now();
    }

    public Post(String title, String posttest, String author){

        this.title = title; this.posttext = posttest; this.author = author;

        publishDate = LocalDateTime.now();
        createDate = LocalDateTime.now();
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosttext() {
        return posttext;
    }

    public void setPosttext(String posttext) {
        this.posttext = posttext;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
