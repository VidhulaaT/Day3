package NotesApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notes {

    //notes id change after removing one note - later


    List<Note> noteList = new ArrayList<>();
//    Map<Integer,Note> map = new HashMap<>();
    //create note, insert note

    private Note createNote(int id,String title,String content){
        Note newNote = new Note();
        newNote.setId(id);
        newNote.setContent(content);
        newNote.setHeading(title);
        return newNote;

    }

    public void insertNote(int id,String heading,String content){
        Note n = createNote(id,heading,content);
        noteList.add(n);
    }

    public void displayNote(Note n){

        System.out.println(n.getId()+" "+n.getHeading());
        System.out.println(n.getContent());
    }

    public void displayAllNotes(){
        for(Note n:noteList){
            System.out.println(n.getId()+" "+n.getHeading()+" "+n.getContent());
        }
    }

    public void viewNote(int id){
        for(Note n:noteList){
            if(n.getId() == id){
                displayNote(n);
            }
        }
    }

    public void deleteNote(int id){
        int size = noteList.size();
        for(int i=0;i<size;i++){
            if(noteList.get(i).getId() == id){
                noteList.remove(i);
                return;
            }
        }
    }


    public void editTitle(int id, String title){
        for(Note n:noteList){
            if(n.getId() == id){
                n.setHeading(title);
            }
        }
    }

    public void editContent(int id , String content){
        for(Note n:noteList){
            if(n.getId() == id){
                n.setContent(content);
            }
        }
    }


}
