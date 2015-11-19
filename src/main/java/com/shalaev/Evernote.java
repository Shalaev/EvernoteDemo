package com.shalaev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergey on 09.11.2015.
 * The class represents a application model.
 *
 */
public class Evernote {
    private Map<Integer, Note> notes = null;

    public Evernote(){
        notes = new HashMap<Integer, Note>();
    }

    /**
     * Adding a new note.
     * @param noteText the text content notes
     */
    public void addNote(String noteText){
        if(!this.notes.containsKey(noteText.hashCode()) && !noteText.isEmpty()) {
            Note temp = new Note();
            temp.setNoteText(noteText);
            notes.put(temp.hashCode(), temp);
        }
    }

    /**
     * Updating the list of notes.
     * @param notes list of notes.
     */
    public void updateNotes(ArrayList<Note> notes){
        for(Note note : notes){
            if(note.isChecked()){
                this.notes.get(note.hashCode()).setDoneStatus(true);
            }
        }
    }

    /**
     * Deleting a note from the list.
     * @param notes the list of notes to be deleted.
     */
    public void deleteNotes(ArrayList<Note> notes){
        for(Note note : notes){
            if(note.isChecked()){
                this.notes.remove(note.hashCode());
            }
        }
    }

    /**
     * Returns a list of stored notes
     * @param shortMode sorting notes modifier.
     *   <ul>
     *      <li>All - will return all notes. </li>
     *      <li>Completed - returns notes with the flag of "Done". </li>
     *      <li>Active - Returns notes that have not yet made. </li>
     *   </ul>
     *
     * @return ArrayList<Note>
     */
    public ArrayList<Note> getNoteList(String shortMode){
        ArrayList<Note> arrayList = new ArrayList<Note>();
        switch (shortMode) {
            case "Active":
                for (Note note : notes.values()) {
                    if(!note.isDoneStatus()){
                        arrayList.add(note);
                    }
                }
                break;
            case "Completed":
                for (Note note : notes.values()) {
                    if(note.isDoneStatus()){
                        arrayList.add(note);
                    }
                }
                break;
            case "All" :
                arrayList.addAll(notes.values());
            default: break;
        }
        return arrayList;
    }

}
