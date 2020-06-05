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
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        //Create the databases
        NeededStatementDatabase needList = new NeededStatementDatabase();
        ExistingStatementDatabase existingList = new ExistingStatementDatabase();
        //MatchedStatementDatabase matchedList = new MatchedStatementDatabase()
        //

        readNeededStatements(needList);
        readExistingStatements(existingList);
        //readandPrintObjectDontSort();

        existingList.printStatements();

    }

    public static void readNeededStatements(NeededStatementDatabase needList) {

        try (Scanner fileScanner = new Scanner(Paths.get("subject.txt"))) {

            while (fileScanner.hasNextLine()) {

                String row = fileScanner.nextLine();
                if (!(row.isEmpty())) {
                    NeededStatement newStatement = new NeededStatement(row);
                    needList.add(newStatement);
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void readExistingStatements(ExistingStatementDatabase existingList) {
        try (Scanner fileScanner = new Scanner(Paths.get("object.txt"))) {
            
            //The format for object.txt needs to be 
            //name
            //content 1
            //content 2 etc (for however many paragraphs there are)
            //[empty line]
            //there needs to be an empty line at the end of the document, otherwise the last entry is not recorded.

            while (fileScanner.hasNextLine()) {

                String name = "";
                String content = "";

                String row = fileScanner.nextLine();

                while (true) {
                    row = row.trim();
                    name = row;
                    break;
                }

                while (true) {
                    row = fileScanner.nextLine();
                    row = row.trim();
                    if (row.isBlank()) {
                        ExistingStatement newStatement = new ExistingStatement(name, content);
                        existingList.add(newStatement);
                        break;
                    }

                    content = content + row + "\n";

                }
                //row = fileScanner.nextLine();
            }

        } catch (Exception e) {
            System.out.println("");
        }

    }

    public static void readandPrintObjectDontSort() {

        try (Scanner fileScanner = new Scanner(Paths.get("object.txt"))) {

            while (fileScanner.hasNextLine()) {

                String row = fileScanner.nextLine();
                System.out.println(row);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
