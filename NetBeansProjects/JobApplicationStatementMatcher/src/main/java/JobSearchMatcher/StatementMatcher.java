package JobSearchMatcher;

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
import java.util.HashMap;

public class StatementMatcher {

    private NeededStatementDatabase needList;
    private ExistingStatementDatabase existingList;
    private ArrayList<ArrayList<Integer>> listOfScores = new ArrayList<>();
    private HashMap<Integer,Integer> matched = new HashMap<>(); 

    public StatementMatcher(NeededStatementDatabase needList, ExistingStatementDatabase existingList) {
        this.needList = needList;
        this.existingList = existingList;
    }
    
    public void scoreTheStatements() {
        
        
        //Goes through the subject list one by one
        for (int subi = 0; subi < this.needList.size(); subi++) {
            String subToMatch = this.needList.getStatement(subi).toString();
            subToMatch = clean(subToMatch);
            String[] subToMatchSplit = subToMatch.split(" ");
            ArrayList<Integer> newList = new ArrayList<>();
                
                //Goes through the object list one by one
                for (int obji = 0; obji < this.existingList.size(); obji++) {
                    String obToMatch = this.existingList.getStatement(obji).getContent();
                    String[] obToMatchSplit = obToMatch.split(" ");
                    int counter = 0;
                    
                    
                    //Takes the each word of the present entry of the subject list
                    for (int subWordi = 0; subWordi < subToMatchSplit.length; subWordi++) {
                        
                        //Compares each word from the current entry of the object list with the current word from the subject
                        //adds one to a counter if the words are the same 
                        for (int objWordi = 0; objWordi < obToMatchSplit.length; objWordi++) {
                            if (obToMatchSplit[objWordi].equals(" ")) {
                                break;
                            }
                            if (subToMatchSplit[subWordi].equals(obToMatchSplit[objWordi])){
                                counter++;
                                                               
                            }
                        }
                        
                    }
                    
                    newList.add(counter);
                }
                listOfScores.add(newList);
        }
        
     

    }
    
    public void matchTheStatements() {
        
        for (int i = 0; i < listOfScores.size(); i++) {
            
            int match = 0;
            
            for (int i2 = 0; i2 < listOfScores.get(i).size(); i2++) {
                if (listOfScores.get(i).get(i2) > match) {
                    match = i2;
                }
            }
            
            matched.put(i, match);
        }
    }
    
    public void printTheStatments() {
        
        for (int i = 0; i < matched.size(); i++) {
            System.out.println(needList.getStatement(i));
            System.out.println("");
            System.out.println(existingList.getStatement(matched.get(i)).getContent());
        }
    }
    
    public void doWeHaveData() {
        
        for (int i = 0; i < listOfScores.size(); i++) {
            for (int i2 = 0; i2< listOfScores.get(i).size(); i2++) {
                System.out.println(listOfScores.get(i).get(i2));
            }
            
            System.out.println("");
        }
    
}

    public String clean(String toMatch) {
        //This should use ArrayList! not simple array!
        String[] parts = toMatch.split(" ");
        String[] highFrequencyWordList = {"the", "and", "a", "to", "said", "in", "he", "I", "of", "it", "was", "you", "they", "on", "she", "is", "for", "at", "his", "but", "that", "with", "all", "we", "can", "are", "up", "had", "my", "her", "what", "there", "out", "this", "have", "went", "be", "like", "some", "so", "not", "then", "were", "go", "little", "as", "no", "an"};
        for (int i = 0; i < highFrequencyWordList.length; i++) {
            for (int i2 = 0; i2 < parts.length; i2++) {
                if (parts[i2].equals(highFrequencyWordList[i])) {
                    parts[i2] = "";
                }
            }
        }
        String result = "";
        for (int i3 = 0; i3 < parts.length; i3++) {

            result = result + parts[i3];
            result = result + " ";
        }
        
        result.trim();

        return result;

    }

    
}
