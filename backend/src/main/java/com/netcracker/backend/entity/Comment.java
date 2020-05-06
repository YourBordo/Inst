package com.netcracker.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;

    @Basic
    @Column(name = "text")
    private String text;

    @Basic
    @Column(name = "date")
    private String date;

/*
   @JsonBackReference(value="comment-user")
*/
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

/*
   @JsonBackReference(value="comment-post")
*/
    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public Comment() {
    }
    public Comment(String text,String date, User user, Post post)
    {
        this.date = date;
        this.text = text;
        this.user = user;
        this.post = post;
    }





}


