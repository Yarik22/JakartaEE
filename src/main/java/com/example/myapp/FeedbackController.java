package com.example.myapp;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class FeedbackController implements Serializable {

    @Inject
    private FeedbackContainer feedbackContainer;

    @NotEmpty(message = "Feedback cannot be empty!")
    @Size(min = 5, max = 500, message = "Feedback must be between 5 and 500 characters!")
    private String newFeedback;

    public String getNewFeedback() {
        return newFeedback;
    }

    public void setNewFeedback(String newFeedback) {
        this.newFeedback = newFeedback;
    }
    
    public void addFeedback() {
        if (newFeedback != null && !newFeedback.trim().isEmpty()) {
            feedbackContainer.addFeedback(newFeedback);
            newFeedback = "";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Feedback cannot be empty!", null));
        }
    }

    public void removeFeedback(Feedback feedback) {
        feedbackContainer.removeFeedback(feedback);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Feedback removed!", null));
    }

    public List<Feedback> getFeedbackList() {
        return feedbackContainer.getFeedbackList();
    }
}
