package com.shalaev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sergey on 05.11.2015.
 * The main application controller
 */
@Controller
public class HomeController {

    private Evernote evernote;

    public HomeController (){
        System.out.println("HomeController HomeController HomeController");
    }

    @Autowired
    public void setEvernote(Evernote evernote) {
        this.evernote = evernote;
    }


    @RequestMapping(value = "/evernote", method = RequestMethod.GET)
    public String index(ModelMap model){
        model.put("noteForm", new NoteForm());
        return "evernote";
    }

    @RequestMapping(value = "/evernote", method = RequestMethod.POST)
    public String addNote(@ModelAttribute(value = "noteForm") NoteForm noteForm, Model model){
        switch (noteForm.getAction()){
            case "Add":
                evernote.addNote(noteForm.getNewNote());
                noteForm.setNewNote("");
                noteForm.setNotes(evernote.getNoteList(noteForm.getShortMode()));
                break;
            case "Update" :
                evernote.updateNotes(noteForm.getNotes());
                noteForm.setNotes(evernote.getNoteList(noteForm.getShortMode()));
                break;
            case "Delete" :
                evernote.deleteNotes(noteForm.getNotes());
                noteForm.setNotes(evernote.getNoteList(noteForm.getShortMode()));
                break;
            case "Short":
                noteForm.setNotes(evernote.getNoteList(noteForm.getShortMode()));
                break;
            default: break;
        }
        model.addAttribute("noteForm", noteForm);
        return "evernote";
    }
}
