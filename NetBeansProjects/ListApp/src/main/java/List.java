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

public class List {
    
    private ArrayList<String> list;
    private String name;
    
    public List(String name) {
        this.list = new ArrayList<>();
        this.name = name;
    }
    
    public void add(String text) {
        this.list.add(text);
    }
    
    public void list() {
        if (this.list.isEmpty()) {
            System.out.println("There's nothing here");
        } else {
            for (int i = 0; i < this.list.size(); i++) {
                System.out.println(i+1 +"- " + this.list.get(i));
                
//            for (String string: this.list) {
//                System.out.println(string);
            }
        }
    }
    
    public void remove(int num) {
        this.list.remove(num - 1);
    }
    
    public int howLong() {
        return this.list.size();
    }
    
    public String toString() {
        return this.name;
    }
    
}
