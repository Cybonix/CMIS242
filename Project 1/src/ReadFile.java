/**
 * File Reader and Main Program
 * 
 * @author Mark Orimoloye
 */
import java.io.*;
import java.util.*;

public class ReadFile 
{
    private Scanner x;
    
    //Method to open file
     public void openFile() 
     {
         // Creates Scanner object with error handler.
         try 
         {
             x = new Scanner(new File("inputText.txt"));
         }
         catch(Exception e)
         {
             System.out.println("could not find file!");
         }
     }
     
     //Reading data from the file
     public void readFile()
     {
         while(x.hasNext()) //While the file has something in it, do...
         {
             String a = x.next();
             String b = x.next();
             String c = x.next();
             String d = x.next();
             String e = x.next();

             
             
             System.out.printf("%s %s %s %s %s %s\n", a,b,c,d,e);
         }
     }
     
     public void closeFile() 
     {
         x.close();
     }   
     
          //Main Program
    public static void main(String[] args)
    {
        ReadFile r = new ReadFile();
        r.openFile();
        r.readFile();
        r.closeFile();
    }

     
}

