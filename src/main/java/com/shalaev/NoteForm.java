package com.shalaev;

import java.util.ArrayList;

/**
 * Created by Sergey on 09.11.2015.
 * Class presentation notes form.
 */
public class NoteForm {
    private ArrayList<Note> notes = null;
    private String newNote;
    private String action;
    private String shortMode;

    public NoteForm(){
        notes = new ArrayList<Note>();
        newNote = "";
        action = "Add";
        shortMode = "All";
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }


    public String getNewNote() {
        return newNote;
    }

    public void setNewNote(String newNote) {
        this.newNote = newNote;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getShortMode() {
        return shortMode;
    }

    public void setShortMode(String shortMode) {
        this.shortMode = shortMode;
    }
}
