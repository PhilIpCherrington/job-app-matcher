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

public class ListOfLists {

    private ArrayList<List> listOfLists;

    public ListOfLists() {
        this.listOfLists = new ArrayList<>();
    }

    public void addList(List list) {
        this.listOfLists.add(list);
    }

    public void removeList(List list) {
        this.listOfLists.remove(list);
    }

    public void listTheLists() {
        if (this.listOfLists.isEmpty()) {
            System.out.println("There are no lists!");
        } else {
            for (int i = 0; i < this.listOfLists.size(); i++) {
                System.out.println(i + 1 + "- " + this.listOfLists.get(i));

            }
        }
    }

    public int size() {
        return this.listOfLists.size();
    }
    
    public List get(int num) {
        return this.listOfLists.get(num - 1);
    }

}
