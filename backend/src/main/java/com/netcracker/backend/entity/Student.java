package com.netcracker.backend.entity;

import javax.persistence.*;

@Entity
public class Student {//
    private long id;
    private String name;


    @Id
    @Column(name ="id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}