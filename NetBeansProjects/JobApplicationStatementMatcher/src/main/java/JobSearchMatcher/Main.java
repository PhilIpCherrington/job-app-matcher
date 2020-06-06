package JobSearchMatcher;

public class Main {

    public static void main(String[] args) {

        //Create the databases
        NeededStatementDatabase needList = new NeededStatementDatabase();
        ExistingStatementDatabase existingList = new ExistingStatementDatabase();


        //Create the object that reads the files and puts info into the databases
        FileReader fileReader = new FileReader(needList, existingList);
        fileReader.readTheFiles();

        //Create the object that matches the statements
        StatementMatcher statementMatcher = new StatementMatcher(needList, existingList);

        statementMatcher.scoreTheStatements();
        statementMatcher.matchTheStatements();
        statementMatcher.printTheStatments();
        //

    }

}
