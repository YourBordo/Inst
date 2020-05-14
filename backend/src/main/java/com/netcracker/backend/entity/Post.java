package com.netcracker.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;


@Entity
public class Post implements Comparable<Post>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;

    @Lob
    @Column(name = "photo")
    private String photo;
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "text")
    private String text;
    @Basic
    @Column(name = "date")
    private String date;
    @Basic
    @Column(name = "place")
    private String place;

    @JsonBackReference(value="user-post")
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }



    @JsonManagedReference(value="comment-post")
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @JsonManagedReference(value="like-post")
    @OneToMany(mappedBy = "post")
    private List<Likes> likes;

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Post(){};
    public Post(String date, long id, String photo, String place, String text, User user) {
        this.date = date;
        this.id = id;
        this.photo = photo;
        this.place = place;
        this.text = text;
        this.user = user;
    }


    @Override
    public int compareTo(Post o) {
        return (this.getDate().compareTo(o.getDate()))*(-1);
    }

}
