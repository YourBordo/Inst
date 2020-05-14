package com.netcracker.fapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class User {
    private long id;
    private String email;
    private String password;
    private String nickname;
    private String firstName;
    private String secondName;
    private String role;
    private boolean banned;
    private List<Complaint>  complaints;
    private List<User> subscribedTo;
    private List<User> subscribedBy;
    private List<Post> posts;
    private List<Likes>  likes;
    private List<Comment>  comments;
    public List<User> getSubscribedTo() {
        return subscribedTo;
    }


    public void setSubscribedTo(List<User> subscribedTo) {
        this.subscribedTo = subscribedTo;
    }
    public List<User> getSubscribedBy() {
        return subscribedBy;
    }
    public void setSubscribedBy(List<User> subscribedBy) {
        this.subscribedBy = subscribedBy;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public boolean isBanned() {
        return banned;
    }
    public void setBanned(boolean banned) {
        this.banned = banned;
    }

}
