package com.failtwoconnect.springbootmentalhealthv2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user_types", schema = "therapyv2")
public class UserType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_type_id;
    @Column(name = "description")
    private String description;

    public UserType() {
    }

    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id(int user_type_id) {
        this.user_type_id = user_type_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
