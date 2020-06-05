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
public class ExistingStatement {
    
    private String name;
    private String content;
    
    public ExistingStatement(String name, String content) {
        this.name = name;
        this.content = content;
    }
    
    @Override
    public String toString() {
        return this.name + ":" + "\n" + this.content;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getContent() {
        return this.content;
    }
    
   
    
}
