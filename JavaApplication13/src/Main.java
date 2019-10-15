import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

        public static String exceptionError(String fileToOpen) throws FileNotFoundException {
            String line;
            Scanner scan = new Scanner(new FileReader(fileToOpen));
            line = scan.nextLine();
            return line;
        }

        public static void main(String[] args) {
            String fileOutput;
            String fileName = "blankfile.txt";

            try {
                fileOutput = exceptionError(fileName);
                System.out.println("Contents of the file: " + fileOutput);
            }
            catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }

        }
}
