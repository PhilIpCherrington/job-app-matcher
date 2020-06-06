/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobSearchMatcher;

import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author philipcherrington
 */
public class FileReader {

    private NeededStatementDatabase needList;
    private ExistingStatementDatabase existingList = new ExistingStatementDatabase();

    public FileReader(NeededStatementDatabase needList, ExistingStatementDatabase existingList) {
        this.needList = needList;
        this.existingList = existingList;
    }

    public void readTheFiles() {
        readNeededStatements();
        readExistingStatements();
    }

    public void readNeededStatements() {

        try (Scanner fileScanner = new Scanner(Paths.get("subject.txt"))) {

            while (fileScanner.hasNextLine()) {

                String row = fileScanner.nextLine();
                if (!(row.isEmpty())) {
                    NeededStatement newStatement = new NeededStatement(row);
                    this.needList.add(newStatement);
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void readExistingStatements() {
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

                row = row.trim();
                name = row;

                while (true) {
                    row = fileScanner.nextLine();
                    row = row.trim();
                    if (row.isBlank()) {
                        ExistingStatement newStatement = new ExistingStatement(name, content);
                        this.existingList.add(newStatement);
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

}
