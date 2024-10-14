package com.example.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

import com.example.containers.NoteContainer;
import com.example.models.Note;

@Path("notes")
@Controller
@RequestScoped
public class NoteController {

    @Inject
    private NoteContainer noteContainer;

    @Inject
    private Models models;

    @GET
    @View("notes.xhtml")
    public void getNotes() {
        List<Note> notes = noteContainer.getNotes();
        models.put("notes", notes);
    }

    @POST
    public Response createNote(@FormParam("newTitle") String newTitle,
            @FormParam("newDescription") String newDescription) {
        Note note = new Note(newTitle, newDescription);
        noteContainer.addNotes(note);
        System.out.println("Added");
        return Response.ok("redirect:notes").build();
    }

    @POST
    @Path("/delete")
    public Response deleteNote(
            @FormParam("id") int id) {  // Get the id from the form data
        noteContainer.deleteById(id);    // Your logic to delete the note
        System.out.println("Deleted note with ID: " + id);
        return Response.ok("redirect:notes").build();  // Redirect or return response
    }
}
