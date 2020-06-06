/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobSearchMatcher;

import java.util.ArrayList;

/**
 *
 * @author philipcherrington
 */
public class MatchedStatementDatabase {

    
    private ArrayList<MatchedStatement> matchedList = new ArrayList<>();
    
    public MatchedStatementDatabase() {
        
    }
    
    public void add(MatchedStatement toAdd) {
        this.matchedList.add(toAdd);
    }
    
    public MatchedStatement getStatement(int num) {
        if (num > this.matchedList.size()) {
            System.out.println("No such entry");
        }
        return this.matchedList.get(num);
    }
    
    public void printStatements() {
        for (int i = 0; i < this.matchedList.size(); i++) {
            System.out.println(this.matchedList.get(i));
        }
    }
    
    
}
    
    
    

