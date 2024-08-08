package NotesApp;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String password;

    private Notes notes;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.notes = new Notes();
    }

    public void addNote(int id,String title, String content){
        notes.insertNote(id,title,content);
    }

    public void delete(int id){
        notes.deleteNote(id);
    }

    public void displayNotes(){
        notes.displayAllNotes();
    }

    public void edit(int n,int id ,String[] temp){
        if(n == 1 || n == 3){
            notes.editTitle(id,temp[0]);
        }
        if(n == 2 || n == 3){
            notes.editContent(id,temp[1]);
        }
    }

}
