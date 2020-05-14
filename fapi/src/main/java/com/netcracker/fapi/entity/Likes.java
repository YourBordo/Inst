package com.netcracker.fapi.entity;

import com.netcracker.fapi.entity.Post;
import com.netcracker.fapi.entity.User;

public class Likes {

    private long id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
