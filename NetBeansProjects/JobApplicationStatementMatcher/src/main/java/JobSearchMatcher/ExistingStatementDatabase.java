/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobSearchMatcher;

/**
 *
 * @author philipcherrington
 */
import java.util.ArrayList;

public class ExistingStatementDatabase {
    
    private ArrayList<ExistingStatement> statementList = new ArrayList<>();
    
    public void add(ExistingStatement toAdd) {
        this.statementList.add(toAdd);
    }
    
    public ExistingStatement getStatement(int num) {
        if (num > this.statementList.size()) {
            System.out.println("No such entry");
        }
        return this.statementList.get(num);
    }
    
    public void printStatements() {
        for (int i = 0; i < this.statementList.size(); i++) {
            System.out.println(this.statementList.get(i));
        }
    }
    
    public int size() {
        return this.statementList.size();
    }
    
    
}
