package NotesApp;

import java.util.Scanner;
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static User loginMenu (MultipleUser mu){

        User u;
        int id = 1;
        while(true){
            System.out.println("Sign Up - 1");
            System.out.println("Login - 2");
            System.out.println("Exit - 3");
            int ip= sc.nextInt();
            sc.nextLine();

            switch(ip){
                case 1:

                    System.out.println("Enter Name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter password : ");
                    String pass = sc.nextLine();

                    mu.createUser(id,name,pass);
                    id++;
                    break;


                case 2:
                    System.out.println("Enter id :");
                    int id4 = sc.nextInt();
                    sc.nextLine();
                    u = mu.existUser(id4);
                    if(u == null){
                        System.out.println("User not found");
                        break;
                    }
                    System.out.println("Enter Name : ");
                    String name1 = sc.nextLine();
                    System.out.println("Enter password : ");
                    String pass1 = sc.nextLine();

                    if(u.getName().equals(name1) && u.getPassword().equals(pass1)){
                        return u;
                    }
                    else{
                        System.out.println("Invalid username and password");
                    }
                    break;


                case 3:
                    return null;


            }
        }

    }
    public static void notesMenu (User user){

        int input;
        int id = 0;

        while (true) {

            System.out.println("Add Notes - 1");
            System.out.println("Edit Notes - 2");
            System.out.println("Delete Notes - 3");
            System.out.println("Display Notes - 4");
            System.out.println("Exit - 5");


            input = sc.nextInt();
            //sc.nextLine();

            switch (input) {


                case 1:
                    sc.nextLine();
                    System.out.println("Enter the Title :");
                    String title = sc.nextLine();

                    System.out.println("Enter the Content :");
                    String cont = sc.nextLine();
                    id++;
                    user.addNote(id, title, cont);
                    break;


                case 2:
                    System.out.println("Enter id :");
                    int id2 = sc.nextInt();
                    System.out.println("Edit title - 1");
                    System.out.println("Edit content - 2");
                    System.out.println("Edit both - 3");

                    int inp = sc.nextInt();
                    sc.nextLine();
                    String[] details = new String[2];
                    if (inp == 1 || inp == 3) {
                        System.out.println("Enter new title :");
                        details[0] = sc.nextLine();
                    }
                    if (inp == 2 || inp == 3) {
                        System.out.println("Enter new content :");
                        details[1] = sc.nextLine();
                    }
                    user.edit(inp,id2,details);

                    break;


                case 3:
                    System.out.println("Enter the Note id to delete");
                    int id1 = sc.nextInt();

                    user.delete(id1);
                    break;

                case 4:
                    user.displayNotes();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Enter a valid input ..");
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome");

        MultipleUser mul = new MultipleUser();
        User u = loginMenu(mul);

        if (u != null) {
            notesMenu(u);
        } else {
            System.out.println("Program terminated");

        }
    }

}
