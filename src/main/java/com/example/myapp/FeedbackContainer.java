package com.example.myapp;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class FeedbackContainer {

    private final List<Feedback> feedbackList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public void addFeedback(String message) {
        Feedback feedback = new Feedback(idCounter.incrementAndGet(), message);
        feedbackList.add(feedback);
    }

    public void removeFeedback(Feedback feedback) {
        feedbackList.remove(feedback);
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }
}
