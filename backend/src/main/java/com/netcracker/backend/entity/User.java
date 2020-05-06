package com.netcracker.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "nickname")
    private String nickname;
    @Basic
    @Column(name = "firstName")
    private String firstName;
    @Basic
    @Column(name = "secondName")
    private String secondName;
    @Basic
    @Column(name = "role")
    private String role;
    @Basic
    @Column(name = "banned")
    private boolean banned;

    @JsonManagedReference(value="complaint-user")
    @OneToMany(mappedBy = "user")
    private List<Complaint>  complaints;

    @JsonManagedReference(value="like-user")
    @OneToMany(mappedBy = "user")
    private List<Likes>  likes;

/*
    @JsonManagedReference(value="comment-user")
    @OneToMany(mappedBy = "user")
    private List<Comment>  comments;
*/


    @ManyToMany
    @JoinTable(
            name = "subscription",
            joinColumns = {
                    @JoinColumn(name = "userId", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "subscriberId", referencedColumnName = "Id")}
                    )

    @JsonIgnore
    private List<User> subscribedTo;
    @ManyToMany(mappedBy = "subscribedTo")
    @JsonIgnore
    private List<User> subscribedBy;

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
