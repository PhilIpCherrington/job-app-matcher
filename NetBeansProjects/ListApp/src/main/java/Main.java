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

public class Main {

    public static void main(String[] args) {
        
        ListOfLists listOfLists = new ListOfLists();
        Scanner scanner = new Scanner(System.in);
        
        UserInterface UI = new UserInterface(listOfLists, scanner);
        
        UI.start();
        
        
        

    }
    
}
