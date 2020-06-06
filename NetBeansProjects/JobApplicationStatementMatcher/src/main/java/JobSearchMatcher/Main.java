/*

Takes two files a 'person specification' file and a 'list of statements' file both in .txt

Makes a list of person specification statements

Makes a  list of statmenets and their answers

Itterates through the person specification list and finds the best matching statment.

Prints the matched statements

Classess: NeededStatement; NeededStatementDatabase; ExistingStatement; ExistingStatementDatabase; MatchedStatement; MatchedStatementDatabase; 
 */
package JobSearchMatcher;

/**
 *
 * @author philipcherrington
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Create the databases
        NeededStatementDatabase needList = new NeededStatementDatabase();
        ExistingStatementDatabase existingList = new ExistingStatementDatabase();
        MatchedStatementDatabase matchedList = new MatchedStatementDatabase();

        //Create the object that reads the files and puts info into the databases
        FileReader fileReader = new FileReader(needList, existingList);
        fileReader.readTheFiles();

        //Create the object that matches the statements
        StatementMatcher statementMatcher = new StatementMatcher(needList, existingList, matchedList);
        ///statementMatcher.matchTheStatements();

        statementMatcher.scoreTheStatements();
        statementMatcher.matchTheStatements();
        statementMatcher.printTheStatments();
        //

    }

}
