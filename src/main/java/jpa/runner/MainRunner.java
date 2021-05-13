package jpa.runner;

import jpa.dao.DatabaseDAO;
import jpa.entitymodels.*;
import jpa.services.RecipeService;
import jpa.services.RoleService;
import jpa.services.UserService;

import javax.persistence.NoResultException;
import java.util.Scanner;

public class MainRunner {
    static Scanner scan = new Scanner(System.in);
    static boolean isRunning = true;
    public static void main(String[] args) {
        DatabaseDAO.startDatabase();
        while(isRunning){
            System.out.println("What would you like to do?");
            System.out.println("1. Log In");
            System.out.println("2. Register");
            System.out.println("3. Quit");
            System.out.println("4. Insert Role into Database");
            int choice = scan.nextInt();
            scan.nextLine();
            if(choice==1){
                UserService userService = new UserService();
                System.out.println("Enter your email");
                String user = scan.nextLine();
                //check if user is in database
                try{
                    User currentUser = userService.findByEmail(user);
                    System.out.println("Enter your password");
                    String password = scan.nextLine();
                    if(currentUser.getPassword().equals(password)){
                        //check whether user is admin or just a normal user

                        System.out.println("Welcome! What would you like to do?");
                        System.out.println("1. View List of Recipes");
                        System.out.println("2. Write New Recipe ");
                        System.out.println("3. Edit your previously published recipes");
                        System.out.println("4. Search for recipe");
                        System.out.println("5. Insert new Ingredient into the Database");
                        System.out.println("6. Add Recipe to date");
                        System.out.println("5. Log out");
                        choice = scan.nextInt();
                        scan.nextLine();
                        switch(choice){
                            case 1: break;
                            case 2: writeRecipe(); break;
                            case 3: break;
                            case 4: break;
                            case 5: break;
                            case 6: break;
                        }
                    }
                }catch(NoResultException e){
                    System.out.println("User not found");
                }

            }
            else if(choice==2){
                UserService userService = new UserService();
                System.out.println("Enter your email address");
                String email = scan.nextLine();
                //check to make sure email address isn't already in the database
                try{
                    User currentUser = userService.findByEmail(email);
                    System.out.println("Email address is already registered!");
                }catch(NoResultException e){ // this is what we want
                    System.out.println("Enter your password");
                    String password = scan.nextLine(); //add password pattern stuff here
                    System.out.println("Reenter your password");
                    String passwordAgain = scan.nextLine();
                    if(password.equals(passwordAgain)){
                        userService.saveToDatabase(new User(email,password));
                    }
                }
//
//                System.out.println();
//                System.out.println("Enter your password");
//                String password = scan.nextLine();
//                System.out.println("Reenter your password");
//                String passwordAgain = scan.nextLine();

                //check to make sure password is entered twice in succession




            }
            else if(choice==3){
                isRunning= false;
            }
            else if(choice==4){
                RoleService roleService = new RoleService();
                System.out.println("Enter Role Name");
                String name = scan.nextLine();
                roleService.saveToDatabase(new Role(name));

            }
            else{
                System.out.println("Invalid input..try again");
            }
        }


    DatabaseDAO.closeDatabase();




    }
    public static void writeRecipe(){
        RecipeService recipeService = new RecipeService();
        System.out.println("Name of recipe?");
        recipeService.saveToDatabase(new Recipe(scan.nextLine()));
    }

    public static void admin(){
        System.out.println("Welcome! What would you like to do?");
        System.out.println("1. View all users");
            // make a user an administrator or a normal user
        System.out.println("3. Publish Recipe");
                //recipes need to be reviewed before they are published
        System.out.println("3. Publish Ingredient");
                //ingredients need to be reviewed before they are published


        System.out.println("4. Log out");
    }
}
