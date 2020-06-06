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

public class NeededStatementDatabase {
    
    private ArrayList<NeededStatement> needList;
    
    public NeededStatementDatabase() {
        this.needList = new ArrayList<>();
    }
    
    public void add(NeededStatement statement) {
        this.needList.add(statement);
    }
    
    public NeededStatement getStatement(int num) {
        return needList.get(num);
    }
    
    public void printStatements() {
        for (int i = 0; i < this.needList.size(); i++) {
            System.out.println(this.needList.get(i));
            
        }
    }
    
    public int size() {
        return this.needList.size();
    } 
}
