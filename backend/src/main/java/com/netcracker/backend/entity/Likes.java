package com.netcracker.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;

    @Basic
    @Column(name = "date")
    private String date;

    @JsonBackReference(value="like-user")
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @JsonBackReference(value="like-post")
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
