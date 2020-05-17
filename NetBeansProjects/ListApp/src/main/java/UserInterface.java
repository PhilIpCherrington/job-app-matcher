/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author philipcherrington
 */
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private ListOfLists listOfLists;

    public UserInterface(ListOfLists listOfLists, Scanner scanner) {
        this.listOfLists = listOfLists;
        this.scanner = scanner;
    }

    public void start() {

        while (true) {
            printMainOptions();
            String input = scanner.nextLine();

            if (input.equals("x") || (input.equals("X"))) {
                break;
            } else if (input.equals("1")) {
                createNewList();
            } else if (input.equals("2")) {
                chooseAList();
            } else if (input.equals("3")) {
                System.out.println("");
                this.listOfLists.listTheLists();
            }  
        }
    }
    
    //Prints the options at the start
    public static void printMainOptions() {
        System.out.println("1 = Create new list");
        System.out.println("2 = Work on existing list");
        System.out.println("3 = Show a list of lists");
        System.out.println("x = Finish");
        System.out.println("");
        System.out.print("What do you want to do? ");
    }
    
    //Creates a new list
    public void createNewList() {
        System.out.println("What do you want to call your new list? (type 'cancel' to escape.)");
        String name = scanner.nextLine();
        List newList = new List(name);
        this.listOfLists.addList(newList);
        System.out.println("Created new list: " + name);
        System.out.println("");
    }
    
    //Lets you choose a list to work on
    public void chooseAList() {
        System.out.println("Which list do you want to work on?");
        this.listOfLists.listTheLists();

        int input = Integer.valueOf(scanner.nextLine());

        if (input > this.listOfLists.size()) {
            System.out.println("No such list exists!");
        } else {
            workOnAList(input);
        }
    }
    
    //The following three methods let you choose a list to work on then add or remove entries
    public void workOnAList(int selection) {
        
        System.out.println("");
        this.listOfLists.get(selection).list();
        System.out.println("");

        while (true) {

            System.out.println("1 - Add to list");
            System.out.println("2 - Remove from list");
            System.out.println("x - Return to main menu");
            System.out.println("");
            System.out.println("What do you want to do?");

            String input = scanner.nextLine();
            if (input.equals("x") || input.equals("X")) {
                break;
            } else if (input.equals("1")) {
                addToExistingList(selection);
            } else if (input.equals("2")) {
                removeFromExistingList(selection);
            }

        }
    }

    public void addToExistingList(int selection) {
        System.out.println("What do you want to add to the list?");
        String text = scanner.nextLine();
        this.listOfLists.get(selection).add(text);

        while (true) {
            System.out.println("Do you want to add anything else?");
            System.out.println("Enter 'y' for yes or 'n' for no");
            text = scanner.nextLine();
            if (text.equals("n")) {
                break;
            } else if (text.equals("y")) {
                System.out.println("What do you want to add to the list?");
                text = scanner.nextLine();
                this.listOfLists.get(selection).add(text);
            }
        }
    }

    public void removeFromExistingList(int selection) {
        List toShow = this.listOfLists.get(selection);
        toShow.list();
        System.out.println("");
        System.out.println("Enter the number of the entry you want to remove");

        int input = Integer.valueOf(scanner.nextLine());
        this.listOfLists.get(selection).remove(input);

        while (true) {
            System.out.println("Do you want to remove anything else?");
            System.out.println("Enter 'y' for yes or 'n' for no");
            String text = scanner.nextLine();
            if (text.equals("n")) {
                break;
            } else if (text.equals("n")) {
                break;
            } else if (text.equals("y")) {
                toShow = this.listOfLists.get(selection);
                toShow.list();
                System.out.println("");
                System.out.println("What do you want to remove from the list?");
                input = Integer.valueOf(scanner.nextLine());
                this.listOfLists.get(selection).remove(input);
            }
        }

    }
    
}
