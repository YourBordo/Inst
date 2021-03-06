package com.netcracker.fapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class Complaint {

    private long id;
    private boolean status;     /*checked/unchecked*/
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

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
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
}
