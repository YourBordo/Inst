package com.netcracker.fapi.entity;

public class Comment {
    private long id;

    private String text;
    private String date;

    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
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


