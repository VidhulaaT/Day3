package NotesApp;

import java.util.ArrayList;
import java.util.List;

public class MultipleUser {

    List<User> userList = new ArrayList<>();

    public void createUser(int id , String name , String password){
        User u = new User(id,name,password);
        userList.add(u);
        System.out.println("Your id is - "+id);
    }

    public User existUser(int id){
        for(User u:userList){
            System.out.println(u.getId()+" "+id);
            if(u.getId() == id){
                System.out.println(u.getId());
                return u;
            }
        }
        return null;
    }
}
