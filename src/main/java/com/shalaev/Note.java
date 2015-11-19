package com.shalaev;

/**
 * Created by Sergey on 09.11.2015.
 * A simple Java class that represents a note.
 * noteText - the text of note
 * doneStatus - flag performed notes.
 * checked - a sign of the selected note.
 */
public class Note {
    private String noteText;
    private boolean doneStatus;
    private boolean checked;


    public Note(){
        this.noteText = "";
        this.doneStatus = false;
        this.checked = false;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public boolean isDoneStatus() {
        return doneStatus;
    }

    public void setDoneStatus(boolean doneStatus) {
        this.doneStatus = doneStatus;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean cheked) {
        this.checked = cheked;
    }

    @Override
    public int hashCode() {
        return getNoteText().hashCode();
    }
}
