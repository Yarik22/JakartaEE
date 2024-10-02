package com.example.myapp;

import java.io.Serializable;

public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String message;

    public Feedback() {
    }

    public Feedback(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
